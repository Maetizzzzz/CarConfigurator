package com.example.carconfigurator.inProgress;

import java.io.Serializable;

public class Brand implements Serializable {
    private int image;
    private String name;

    public Brand(int image, String name){
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
