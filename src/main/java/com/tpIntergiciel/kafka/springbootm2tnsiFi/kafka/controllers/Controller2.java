package com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.controllers;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.producers.Producer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {

    private final Producer2 producer;

    @Autowired
    public Controller2(Producer2 producer) {
        this.producer = producer;
    }
    @PostMapping("/get_global_values")
    public void messageToTopic(){

    }
}