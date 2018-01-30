package com.example.weather.beans;

/**
 * Created by aruna on 1/30/18.
 */

class ListWind {
    private double speed;
    private double deg;

    public ListWind(double speed, double deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDeg() {
        return deg;
    }
}
