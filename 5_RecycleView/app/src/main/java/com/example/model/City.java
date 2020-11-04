package com.example.model;

import androidx.annotation.NonNull;

public class City {
    private String name;
    private int idImage;

    public City(String name, int idImage) {
        this.name = name;
        this.idImage = idImage;
    }

    public int getIdImage() {
        return idImage;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
