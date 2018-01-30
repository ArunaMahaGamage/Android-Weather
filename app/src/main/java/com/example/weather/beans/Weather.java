package com.example.weather.beans;

import java.util.List;

/**
 * Created by aruna on 1/30/18.
 */

public class Weather {

    private String cod;

    private double message;

    private int cnt;

    private List <Lists> list;

    private  City city;

    public Weather(String cod, double message, int cnt, List<Lists> list, City city) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public void setList(List<Lists> list) {
        this.list = list;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public double getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public List<Lists> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }
}
