package com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.repositories.GlobalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlobalService {

    @Autowired
    private GlobalRepository globalRepository;
}
