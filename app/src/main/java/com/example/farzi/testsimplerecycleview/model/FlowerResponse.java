package com.example.farzi.testsimplerecycleview.model;

import com.google.gson.annotations.Expose;

import io.realm.RealmObject;

/**
 * Created by Farzi on 28/06/2017.
 */

public class FlowerResponse implements FloweResponseData {
    @Expose
    private String category;
    @Expose
    private String instructions;
    @Expose
    private String photo;
    @Expose
    private String name;
    @Expose
    private double price;
    @Expose
    private int productId;

    @Override
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
