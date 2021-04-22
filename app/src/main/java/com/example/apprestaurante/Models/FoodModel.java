package com.example.apprestaurante.Models;

import android.graphics.Bitmap;

public class FoodModel {
    String name, price, description;
    int id;
    Bitmap image;

    public FoodModel(int id, String name, String price, String description, Bitmap image) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
