package com.example.carconfigurator.model;

import java.io.Serializable;

public class Model implements Serializable {
    private int id;
    private String name;
    private double price;
    private int image;
    private int id_brand;

    public Model(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public Model(int id, String name, double price, int image, int id_brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.id_brand = id_brand;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getId_brand() {
        return id_brand;
    }
}
