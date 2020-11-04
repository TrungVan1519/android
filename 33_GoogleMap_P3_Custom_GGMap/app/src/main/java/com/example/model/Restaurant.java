package com.example.model;

import java.io.Serializable;

public class Restaurant implements Serializable {
    private String name;
    private int idImage;
    private double viDo, kinhDo;

    public Restaurant(String name, int idImage, double viDo, double kinhDo) {
        this.name = name;
        this.idImage = idImage;
        this.viDo = viDo;
        this.kinhDo = kinhDo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public double getViDo() {
        return viDo;
    }

    public void setViDo(double viDo) {
        this.viDo = viDo;
    }

    public double getKinhDo() {
        return kinhDo;
    }

    public void setKinhDo(double kinhDo) {
        this.kinhDo = kinhDo;
    }
}
