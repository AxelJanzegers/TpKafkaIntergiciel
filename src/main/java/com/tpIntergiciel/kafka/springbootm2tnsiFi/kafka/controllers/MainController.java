package com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.controllers;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.producers.Producer2;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.producers.Producer3;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities.Country;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities.Global;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services.CountryService;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services.GlobalService;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class MainController {

    private Producer2 producer2;
    private Producer3 producer3;

    @Autowired
    private GlobalService globalService;
    @Autowired
    private CountryService countryService;


    @Autowired
    public MainController(Producer2 producer2, Producer3 producer3) {
        this.producer2 = producer2;
        this.producer3 = producer3;
    }

    @PostMapping("/request")
    public void messageToTopic(@RequestParam("req") String command){
        this.producer2.sendMessage(command);
    }

    @PostMapping("/request_param")
    public void messageToTopicWithParam(@RequestParam("req") String command, @RequestParam("param") String country) {
        this.producer2.sendMessage(command + " " + country);
    }

    @GetMapping("/get_global_values")
    public void getGlobalValuesToTopic() {
        Global global = globalService.getGlobal();
        this.producer3.sendMessage(global.toString());
    }

    @PostMapping("/get_country_values")
    public void getCountryValuesToTopic(@RequestParam("req") String country) {
        Country country1 = countryService.getCountry(country);
        this.producer3.sendMessage(country1.toString());
    }

    @GetMapping("/get_confirmed_avg")
    public void getConfirmedAvgToTopic() {
        String message = "\nAverage confirmed : " + globalService.averageConfirmed();
        this.producer3.sendMessage(message);
    }

    @GetMapping("/get_deaths_avg")
    public void getDeathsAvgToTopic() {
        String message = "\nAverage deaths : " + globalService.averageDeaths();
        this.producer3.sendMessage(message);
    }

    @GetMapping("/get_countries_deaths_percent")
    public void getCountriesDeathsPercentToTopic() {
        HashMap<String, Float> hmap = countryService.getDeathPercent();
        String message = " --- DEATH PERCENTAGE BY COUNTRY ---\n";
        Map<String, Float> tmap = hmap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> newValue, TreeMap::new));
        for(Map.Entry<String, Float> entry : tmap.entrySet()) {
            message += "Death percentage in " + entry.getKey() + " : " + entry.getValue() + "%.\n";
        }
        this.producer3.sendMessage(message);
    }

    @PostMapping("/get_countries_deaths_percent")
    public void getCountriesDeathsPercentToTopic(@RequestParam("req") String country) {
        HashMap<String, Float> map = countryService.getDeathPercent(country);
        String message = "";
        for(Map.Entry<String, Float> entry : map.entrySet()) {
            message += "Death percentage in " + entry.getKey() + " : " + entry.getValue() + "%.\n";
        }
        this.producer3.sendMessage(message);
    }
}