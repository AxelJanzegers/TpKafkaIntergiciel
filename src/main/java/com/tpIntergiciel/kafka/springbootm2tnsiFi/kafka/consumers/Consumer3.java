package com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.consumers;

import com.google.gson.Gson;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.JsonMessage;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services.CountryService;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer3 {

    @Autowired
    private CountryService countryService;
    @Autowired
    private GlobalService globalService;

    @KafkaListener(topics = "result_topic", groupId = "group_id")
    public void consumeMessage(String msg) {
        System.out.println(msg);
    }

}
