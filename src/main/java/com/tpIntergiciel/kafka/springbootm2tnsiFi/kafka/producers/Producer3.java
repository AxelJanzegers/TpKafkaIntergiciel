package com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.producers;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

    @Service
    public class Producer3 {
        private static final String TOPIC = "result_topic";
        @Autowired
        private KafkaTemplate<String,String> kafkaTemplate;

        public void sendMessage(String msg){
            this.kafkaTemplate.send(TOPIC, msg);
        }

        @Bean
        public NewTopic createResultTopic(){
            return new NewTopic(TOPIC,1,(short) 1);
        }
}
