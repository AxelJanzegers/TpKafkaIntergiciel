package com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.consumers;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.JsonMessage;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities.Global;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.repositories.CountryRepository;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.repositories.GlobalRepository;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services.CountryService;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;


@Service
@Transactional
public class APIConsumer {

    @Autowired
    private CountryService countryService;
    @Autowired
    private GlobalService globalService;

    @KafkaListener(topics = "api_topic", groupId = "group_id")
    public void consumeMessage(String msg) {
        /*
        * Ajout dans la bdd
        */
        Gson gson = new Gson();
        JsonMessage json = gson.fromJson(msg, JsonMessage.class);
        globalService.createGlobal(json.getGlobal());
        countryService.createCountries(json.getCountries());
    }


}
