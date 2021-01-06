package com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Country {

    @Id
    @GeneratedValue
    private String id;

    private String countryName;
    private String countryCode;
    private String slug;
    private int newConfirmed;
    private int totalConfirmed;
    private int newDeaths;
    private int totalDeaths;
    private int newRecovered;
    private int totalRecovered;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getNewConfirmed() {
        return newConfirmed;
    }

    public void setNewConfirmed(int newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public int getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public int getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(int newRecovered) {
        this.newRecovered = newRecovered;
    }

    public int getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        this.totalRecovered = totalRecovered;
    }
}
