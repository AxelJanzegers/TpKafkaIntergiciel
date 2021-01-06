package com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities.Country;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public void createCountries(Collection<Country> countries) {
        countryRepository.saveAll(countries);
    }
}
