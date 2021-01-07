package com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.controllers;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.producers.Producer2;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities.Global;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller2 {

    private Producer2 producer;

    @Autowired
    public Controller2(Producer2 producer) {
        this.producer = producer;
    }

    @Autowired
    private GlobalService globalService;

    @PostMapping("/request")
    public void messageToTopic(@RequestParam("req") String command) {
        this.producer.sendMessage(command);
    }
}