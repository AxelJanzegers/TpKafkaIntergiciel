package com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.controllers;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.producers.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final Producer producer;

    @Autowired
    public MainController(Producer producer) {
        this.producer = producer;
    }
    @PostMapping("/sendMsg")
    public void messageToTopic(@RequestParam("msg") String msg){

        this.producer.sendMessage(msg);

    }
}