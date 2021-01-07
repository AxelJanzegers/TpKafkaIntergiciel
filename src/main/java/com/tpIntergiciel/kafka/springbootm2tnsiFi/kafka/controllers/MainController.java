package com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.controllers;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.producers.Producer2;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka.producers.Producer3;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities.Global;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services.CountryService;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.services.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    }

    @GetMapping("/get_confirmed_avg")
    public void getConfirmedAvgToTopic() {

    }

    @GetMapping("/get_deaths_avg")
    public void getDeathsAvgToTopic() {

    }

    @GetMapping("/get_countries_deaths_percent")
    public void getCountriesDeathsPercentToTopic() {

    }
}