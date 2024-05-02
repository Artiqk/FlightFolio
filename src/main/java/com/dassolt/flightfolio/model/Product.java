package com.dassolt.flightfolio.model;

public class Product {
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isCanSpreadDemocracy() {
        return canSpreadDemocracy;
    }

    public void setCanSpreadDemocracy(boolean canSpreadDemocracy) {
        this.canSpreadDemocracy = canSpreadDemocracy;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public int getEngineManufacturerId() {
        return engineManufacturerId;
    }

    public void setEngineManufacturerId(int engineManufacturerId) {
        this.engineManufacturerId = engineManufacturerId;
    }

    public int getCategoryId() {
        return categoryId;
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
