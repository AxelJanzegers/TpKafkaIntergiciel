package com.tpIntergiciel.kafka.springbootm2tnsiFi;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @KafkaListener(topics = "test_topic",groupId = "group_id")
    public void consumeMessage(String msg) {

        System.out.println(msg);
    }
}