package com.example.carconfigurator.upholstery;

import java.io.Serializable;

public class Upholstery implements Serializable {
    private int id;
    private String upholstery;
    private double price;
    private int image;
    private String standard;
    private int id_brand;

    public Upholstery(int id, String upholstery, double price, int image, String standard, int id_brand) {
        this.id = id;
        this.upholstery = upholstery;
        this.price = price;
        this.image = image;
        this.standard = standard;
        this.id_brand = id_brand;
    }

    public int getId() {
        return id;
    }

    public String getUpholstery() {
        return upholstery;
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
