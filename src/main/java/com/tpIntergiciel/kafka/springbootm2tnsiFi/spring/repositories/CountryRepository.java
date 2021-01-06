package com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.repositories;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {
}
