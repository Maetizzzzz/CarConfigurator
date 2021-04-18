package com.example.carconfigurator.colour;

import java.io.Serializable;

public class Colour implements Serializable {
    private int id;
    private String name;
    private double price;
    private int image;
    private String standard;
    private int id_brand;

    public Colour(int id, String name, double price, int image, String standard, int id_brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.standard = standard;
        this.id_brand = id_brand;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    public String getStandard() {
        return standard;
    }

    public int getId_brand() {
        return id_brand;
    }
}
