package com.example.carconfigurator.inProgress;

import java.io.Serializable;

public class Model implements Serializable {
    private int image;
    private String name;

    public Model(int image, String name){
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
