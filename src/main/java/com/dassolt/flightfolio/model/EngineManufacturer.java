package com.dassolt.flightfolio.model;

import java.util.Objects;
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
        return this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EngineManufacturer that = (EngineManufacturer) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
