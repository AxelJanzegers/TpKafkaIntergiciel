package com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities.Country;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;


    public Country getCountry(String countryName){
        var countries = (List<Country>) countryRepository.findAll();
        Country result = new Country();
        for(Country c : countries) {
            if(c.getCountry().contains(countryName)){
                result = c;
            }
        }

        return result;
    }

    @Transactional
    public void createCountries(Collection<Country> countries) {
        countryRepository.saveAll(countries);
    }
}
