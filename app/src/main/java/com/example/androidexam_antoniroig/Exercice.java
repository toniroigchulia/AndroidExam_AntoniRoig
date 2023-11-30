package com.example.androidexam_antoniroig;

import java.io.Serializable;

public class Exercice implements Serializable {
    private String name;
    private int imageResource;
    private String description;

    public Exercice(String name, int imageResource, String description){
        this.imageResource = imageResource;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDescription() {
        return description;
    }
}
