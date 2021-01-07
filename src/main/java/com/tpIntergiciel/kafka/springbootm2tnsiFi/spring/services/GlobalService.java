package com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities.Global;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.repositories.GlobalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GlobalService {

    @Autowired
    private GlobalRepository globalRepository;


    public Global getGlobal() {
        return globalRepository.findById(1).get();
    }

    @Transactional
    public int createGlobal(Global global) {
        return globalRepository.save(global).getId();
    }


}
