package com.example.model;

import androidx.annotation.NonNull;

public class Item {
    private String content;
    private int idImage;

    public Item(String content, int idImage) {
        this.content = content;
        this.idImage = idImage;
    }

    public int getIdImage() {
        return idImage;
    }

    @NonNull
    @Override
    public String toString() {
        return content;
    }
}
