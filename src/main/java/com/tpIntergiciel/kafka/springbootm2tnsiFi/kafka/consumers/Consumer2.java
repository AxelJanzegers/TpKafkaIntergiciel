package com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer2 {
    @KafkaListener(topics = "test_topic",groupId = "group_id")
    public void consumeMessage(String msg) {

        System.out.println(msg);
    }
}
