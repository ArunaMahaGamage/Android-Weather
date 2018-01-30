package com.example.weather.beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aruna on 1/30/18.
 */

class ListRain {
    @SerializedName("3h")
    private double rein3h;

    public ListRain(double rein3h) {
        this.rein3h = rein3h;
    }

    public void setRein3h(double rein3h) {
        this.rein3h = rein3h;
    }

    public double getRein3h() {
        return rein3h;
    }
}
