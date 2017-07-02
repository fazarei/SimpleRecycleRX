package com.example.farzi.testsimplerecycleview;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Created by Farzi on 29/06/2017.
 */

public class UserAndEvents {

    public UserAndEvents(JsonObject user, JsonArray events) {
        this.events = events;
        this.user = user;
    }

    public JsonArray events;
    public JsonObject user;
}
