package com.example.androidexam_antoniroig;

import java.io.Serializable;

public class Exercice implements Serializable {
    private String name;

    public Exercice(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
