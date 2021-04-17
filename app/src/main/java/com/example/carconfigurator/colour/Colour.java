package com.example.carconfigurator.colour;

import java.io.Serializable;

public class Colour implements Serializable {
    private int id;
    private String colour;
    private double price;
    private int image;
    private String standard;
    private int id_brand;

    public Colour(int id, String colour, double price, int image, String standard, int id_brand) {
        this.id = id;
        this.colour = colour;
        this.price = price;
        this.image = image;
        this.standard = standard;
        this.id_brand = id_brand;
    }

    public int getId() {
        return id;
    }

    public String getColour() {
        return colour;
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
