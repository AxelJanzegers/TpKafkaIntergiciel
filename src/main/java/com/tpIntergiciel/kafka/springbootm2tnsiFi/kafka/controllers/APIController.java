package com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.controllers;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.producers.APIProducer;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities.Global;
import org.apache.kafka.common.metrics.stats.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class APIController {

    private APIProducer producer;

    @Autowired
    public APIController(APIProducer producer) { this.producer = producer; }

    /**
     * Demande les infos à l'api
     * Envoie au consommateur 1 (APIConsumer) les infos
     * @throws IOException
     */
    @GetMapping("/summary")
    public void messageToTopic() throws IOException {
        String link = "https://api.covid19api.com/summary";
        String msg;
        URL url = new URL(link);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            msg = readStream(in);
        } finally {
            urlConnection.disconnect();
        }
        this.producer.sendMessage(msg);
    }

    private String readStream(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new InputStreamReader(is),1000);
        for (String line = r.readLine(); line != null; line =r.readLine()){
            sb.append(line);
        }
        is.close();
        return sb.toString();
    }
}
