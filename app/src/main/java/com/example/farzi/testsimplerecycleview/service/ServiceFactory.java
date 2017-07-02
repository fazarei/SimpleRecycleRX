package com.example.farzi.testsimplerecycleview.service;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Farzi on 28/06/2017.
 */

public class ServiceFactory {
    public Retrofit createRetrofit()
    {
        return new Retrofit.Builder()
                .baseUrl("http://services.hanselandpetal.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
