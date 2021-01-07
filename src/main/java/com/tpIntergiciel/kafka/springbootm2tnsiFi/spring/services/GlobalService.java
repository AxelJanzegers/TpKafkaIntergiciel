package com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities.Global;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.repositories.CountryRepository;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.repositories.GlobalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GlobalService {

    @Autowired
    private GlobalRepository globalRepository;

    @Autowired
    private CountryRepository countryRepository;


    public Global getGlobal() {
        return globalRepository.findById(1).get();
    }

    public int averageConfirmed() {
        Global global = globalRepository.findById(1).get();
        return (int) (global.getTotalConfirmed()/countryRepository.count());
    }

    public int averageDeaths() {
        Global global = globalRepository.findById(1).get();
        return (int) (global.getTotalDeaths()/countryRepository.count());
    }

    @Transactional
    public int createGlobal(Global global) {
        return globalRepository.save(global).getId();
    }


}
