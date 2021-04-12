package com.example.carconfigurator.brand;

import java.io.Serializable;

public class Brand implements Serializable {
    private Integer image;
    private String name;
    private int id;

    public Brand(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public Brand(int id, String name, Integer image) {
        this.image = image;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Integer getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
