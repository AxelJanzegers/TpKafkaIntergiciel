package com.tpIntergiciel.kafka.springbootm2tnsiFi.kafka;

import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities.Country;
import com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities.Global;

import java.util.Collection;
import java.util.Date;

public class JsonMessage {

    private String Message;
    private Global Global;
    private Collection<Country> Countries;
    private Date Date;

    public JsonMessage () {}

    public JsonMessage(String Message, Global Global, Collection<Country> Countries, Date Date) {
        this.Message = Message;
        this.Global = Global;
        this.Countries = Countries;
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "JsonMessage{" +
                "Message='" + Message + '\'' +
                ", Global=" + Global.toString() +
                ", Date=" + Date +
                '}';
    }

    public void countriesToString () {
        Countries.forEach(country -> System.out.println(country.toString()));
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public void setGlobal(Global Global) {
        this.Global = Global;
    }

    public void setCountries(Collection<Country> Countries) {
        this.Countries = Countries;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities.Global getGlobal() {
        return this.Global;
    }

    public Collection<Country> getCountries() {
        return Countries;
    }
}
