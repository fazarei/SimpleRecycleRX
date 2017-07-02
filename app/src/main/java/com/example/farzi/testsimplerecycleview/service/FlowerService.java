package com.example.farzi.testsimplerecycleview.service;

import com.example.farzi.testsimplerecycleview.model.FlowerResponse;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Farzi on 28/06/2017.
 */

public interface FlowerService {

    @GET("/feeds/flowers.json")
    Observable<List<FlowerResponse>> getFlower();
}
