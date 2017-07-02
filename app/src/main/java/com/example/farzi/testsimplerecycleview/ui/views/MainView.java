package com.example.farzi.testsimplerecycleview.ui.views;

import android.content.Context;

import com.example.farzi.testsimplerecycleview.model.FlowerResponse;

import java.util.List;

/**
 * Created by Farzi on 28/06/2017.
 */

public interface MainView {
    Context getContext();

    void onFlower(List<FlowerResponse> flowerResponses);
}
