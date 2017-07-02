package com.example.farzi.testsimplerecycleview;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Farzi on 29/06/2017.
 */

public interface GitHubEvents {
        @GET("users/{user}/events")
        Observable<JsonArray> listEvents(@Path("user") String user);
}
