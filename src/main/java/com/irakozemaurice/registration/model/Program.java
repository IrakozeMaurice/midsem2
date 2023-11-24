package com.irakozemaurice.registration.model;

public enum Program {

    UNDERGRADUATE("Undergraduate"),
    MASTERS("Masters");

    private String name;

    Program(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
