package com.tpIntergiciel.kafka.springbootm2tnsiFi.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Global {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private int NewConfirmed;
    private int TotalConfirmed;
    private int NewDeaths;
    private int TotalDeaths;
    private int NewRecovered;
    private int TotalRecovered;

    public Global() { }

    public Global(int NewConfirmed, int TotalConfirmed, int NewDeaths, int TotalDeaths, int NewRecovered, int TotalRecovered) {
        this.NewConfirmed = NewConfirmed;
        this.TotalConfirmed = TotalConfirmed;
        this.NewDeaths = NewDeaths;
        this.TotalDeaths = TotalDeaths;
        this.NewRecovered = NewRecovered;
        this.TotalRecovered = TotalRecovered;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getNewConfirmed() {
        return NewConfirmed;
    }

    public void setNewConfirmed(int NewConfirmed) {
        this.NewConfirmed = NewConfirmed;
    }

    public int getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(int TotalConfirmed) {
        this.TotalConfirmed = TotalConfirmed;
    }

    public int getNewDeaths() {
        return NewDeaths;
    }

    public void setNewDeaths(int NewDeaths) {
        this.NewDeaths = NewDeaths;
    }

    public int getTotalDeaths() {
        return TotalDeaths;
    }

    public void setTotalDeaths(int TotalDeaths) {
        this.TotalDeaths = TotalDeaths;
    }

    public int getNewRecovered() {
        return NewRecovered;
    }

    public void setNewRecovered(int NewRecovered) {
        this.NewRecovered = NewRecovered;
    }

    public int getTotalRecovered() {
        return TotalRecovered;
    }

    public void setTotalRecovered(int TotalRecovered) {
        this.TotalRecovered = TotalRecovered;
    }

    @Override
    public String toString() {
        return "Global{" +
                "id='" + id + '\'' +
                ", NewConfirmed=" + NewConfirmed +
                ", TotalConfirmed=" + TotalConfirmed +
                ", NewDeaths=" + NewDeaths +
                ", TotalDeaths=" + TotalDeaths +
                ", NewRecovered=" + NewRecovered +
                ", TotalRecovered=" + TotalRecovered +
                '}';
    }
}
