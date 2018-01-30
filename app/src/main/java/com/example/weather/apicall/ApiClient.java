package com.example.weather.apicall;


import android.util.Log;

import com.example.weather.Service;
import com.example.weather.beans.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aruna on 1/30/18.
 */

public class ApiClient {

    public Call getAPICall() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create());

        final Retrofit retrofit = builder.build();

        Service client = retrofit.create(Service.class);

        Call<Weather> call = client.repoForUser();

        return call;
    }
}

