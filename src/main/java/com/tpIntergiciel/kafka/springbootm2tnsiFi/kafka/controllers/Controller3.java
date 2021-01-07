package com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.controllers;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.producers.Producer3;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Controller3 {

    private Producer3 producer;

    @Autowired
    public Controller3(Producer3 producer) {
        this.producer = producer;
    }

    @Autowired
    private GlobalService globalService;

    /**
     * Demande les infos à la BDD
     * Envoie au consommateur 3 les infos dans un fichier JSON
     * @throws IOException
     */
    @GetMapping("/infoJSON")
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
