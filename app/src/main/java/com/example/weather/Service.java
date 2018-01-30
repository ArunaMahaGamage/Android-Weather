package com.example.weather;

import com.example.weather.beans.Weather;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aruna on 1/30/18.
 */

public interface Service {

    @GET("/data/2.5/forecast?lat=6.927078600000002&lon=79.86124300000006&appid=55e0b0f3e5d1350a334b729063be902e")
    Call <Weather> repoForUser();
}
