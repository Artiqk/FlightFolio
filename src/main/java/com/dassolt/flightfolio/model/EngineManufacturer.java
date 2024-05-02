package com.dassolt.flightfolio.model;

import java.util.UUID;

public class EngineManufacturer {
    private final String id;
    private String name;

    public EngineManufacturer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public EngineManufacturer(String name) {
        this(UUID.randomUUID().toString(), name);
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
