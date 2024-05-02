package com.dassolt.flightfolio.model;

import java.util.UUID;

public class Manufacturer {
    private final String id;
    private String name;

    public Manufacturer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Manufacturer(String name) {
        this(UUID.randomUUID().toString(), name);
    }

    public String getId() {
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
        return String.format("(%s): %s", this.getId(), this.getName());
    }
}
