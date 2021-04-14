package com.example.carconfigurator.engine;

import java.io.Serializable;

public class Engine implements Serializable {
    private int id;
    private String name;
    private double price;
    private int number_gear;
    private int max_torque;
    private String co2_emission;
    private String in_town;
    private String total_consumption;
    private String out_of_town;
    private String co2_efficiency_class;
    private String gearbox;
    private String fuel;
    private int image;
    private int id_brand;

    public Engine(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public Engine(int id, String name, double price, int number_gear, int max_torque, String co2_emission, String in_town, String total_consumption, String out_of_town, String co2_efficiency_class, String gearbox, String fuel, int image, int id_brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number_gear = number_gear;
        this.max_torque = max_torque;
        this.co2_emission = co2_emission;
        this.in_town = in_town;
        this.total_consumption = total_consumption;
        this.out_of_town = out_of_town;
        this.co2_efficiency_class = co2_efficiency_class;
        this.gearbox = gearbox;
        this.fuel = fuel;
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

    public int getNumber_gear() {
        return number_gear;
    }

    public int getMax_torque() {
        return max_torque;
    }

    public String getCo2_emission() {
        return co2_emission;
    }

    public String getIn_town() {
        return in_town;
    }

    public String getTotal_consumption() {
        return total_consumption;
    }

    public String getOut_of_town() {
        return out_of_town;
    }

    public String getCo2_efficiency_class() {
        return co2_efficiency_class;
    }

    public String getGearbox() {
        return gearbox;
    }

    public String getFuel() {
        return fuel;
    }
}
