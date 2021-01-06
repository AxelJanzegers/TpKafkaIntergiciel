package com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.repositories;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities.Global;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalRepository extends CrudRepository<Global, Integer> {
}
