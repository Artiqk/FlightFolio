package com.dassolt.flightfolio.model;

public class Product {
    private final int id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private int engineNb;
    private int seatNb;
    private double wingspan;
    private double length;
    private int serviceCeiling;
    private boolean canSpreadDemocracy;
    private int manufacturerId;
    private int engineManufacturerId;
    private int categoryId;

    public Product(int id, String name, String description, double price, int quantity, int engineNb, int seatNb, double wingspan, double length, int serviceCeiling, boolean canSpreadDemocracy, int manufacturerId, int engineManufacturerId, int categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.engineNb = engineNb;
        this.seatNb = seatNb;
        this.wingspan = wingspan;
        this.length = length;
        this.serviceCeiling = serviceCeiling;
        this.canSpreadDemocracy = canSpreadDemocracy;
        this.manufacturerId = manufacturerId;
        this.engineManufacturerId = engineManufacturerId;
        this.categoryId = categoryId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getEngineNb() {
        return engineNb;
    }

    public void setEngineNb(int engineNb) {
        this.engineNb = engineNb;
    }

    public int getSeatNb() {
        return seatNb;
    }

    public void setSeatNb(int seatNb) {
        this.seatNb = seatNb;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getServiceCeiling() {
        return serviceCeiling;
    }

    public void setServiceCeiling(int serviceCeiling) {
        this.serviceCeiling = serviceCeiling;
    }

    public boolean canSpreadDemocracy() {
        return canSpreadDemocracy;
    }

    public void setCanSpreadDemocracy(boolean canSpreadDemocracy) {
        this.canSpreadDemocracy = canSpreadDemocracy;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public int getEngineManufacturerId() {
        return engineManufacturerId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public void setEngineManufacturerId(int engineManufacturerId) {
        this.engineManufacturerId = engineManufacturerId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return String.format("Name : %s\n\nDescription : %s\n\nPrice : %.2f\n\nQuantity : %d",
                             this.getName(), this.getDescription(), this.getPrice(), this.getQuantity());
    }
}
