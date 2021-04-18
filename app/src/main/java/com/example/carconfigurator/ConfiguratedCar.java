package com.example.carconfigurator;

import com.example.carconfigurator.brand.Brand;
import com.example.carconfigurator.colour.Colour;
import com.example.carconfigurator.engine.Engine;
import com.example.carconfigurator.model.Model;
import com.example.carconfigurator.upholstery.Upholstery;
import com.example.carconfigurator.version.Version;

import java.io.Serializable;

public class ConfiguratedCar implements Serializable {
    private Brand brand;
    private Model model;
    private Version version;
    private Engine engine;
    private Colour colour;
    private Upholstery upholstery;
    private String name;

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

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Colour getColour() {
        return colour;
    }

    public Upholstery getUpholstery() {
        return upholstery;
    }

    public void setUpholstery(Upholstery upholstery) {
        this.upholstery = upholstery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
