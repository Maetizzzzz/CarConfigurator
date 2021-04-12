package com.example.carconfigurator.inProgress;

import java.io.Serializable;

public class ConfiguratedCar implements Serializable {
    private Brand brand;
    private Model model;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
