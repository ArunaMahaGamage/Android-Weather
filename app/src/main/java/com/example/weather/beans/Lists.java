package com.example.weather.beans;

import java.util.List;

/**
 * Created by aruna on 1/30/18.
 */

public class Lists {

    private int dt;
    private ListMain main;
    private List<ListWeather> weather;
    private ListClouds clouds;
    private ListWind wind;
    private ListRain rain;
    private ListSys sys;
    private String dt_txt;

    public Lists(int dt, ListMain main, List<ListWeather> weather, ListClouds clouds, ListWind wind, ListRain rain, ListSys sys, String dt_txt) {
        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.rain = rain;
        this.sys = sys;
        this.dt_txt = dt_txt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public void setMain(ListMain main) {
        this.main = main;
    }

    public void setWeather(List<ListWeather> weather) {
        this.weather = weather;
    }

    public void setClouds(ListClouds clouds) {
        this.clouds = clouds;
    }

    public void setWind(ListWind wind) {
        this.wind = wind;
    }

    public void setRain(ListRain rain) {
        this.rain = rain;
    }

    public void setSys(ListSys sys) {
        this.sys = sys;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public int getDt() {
        return dt;
    }

    public ListMain getMain() {
        return main;
    }

    public List<ListWeather> getWeather() {
        return weather;
    }

    public ListClouds getClouds() {
        return clouds;
    }

    public ListWind getWind() {
        return wind;
    }

    public ListRain getRain() {
        return rain;
    }

    public ListSys getSys() {
        return sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }
}
