package com.example.carconfigurator.version;

import java.io.Serializable;

public class Version implements Serializable {
    private int id;
    private String name;
    private double price;
    private int image;
    private int id_brand;
    private int id_model;

    public Version(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public Version(int id, String name, double price, int image, int id_brand, int id_model) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.id_brand = id_brand;
        this.id_model = id_model;
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

    public int getId_model() {
        return id_model;
    }

    @Override
    public String toString() {
        return "Version{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", image=" + image +
                ", id_brand=" + id_brand +
                ", id_model=" + id_model +
                '}';
    }
}
