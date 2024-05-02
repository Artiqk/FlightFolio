package com.dassolt.flightfolio.model;

public class EngineManufacturer {
    private final int id;
    private String name;

    public EngineManufacturer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
