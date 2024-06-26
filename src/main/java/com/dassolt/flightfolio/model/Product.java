package com.dassolt.flightfolio.model;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;

public class Product {
    private final String id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private int engineNb;
    private int seatNb;
    private int serviceCeiling;
    private boolean canSpreadDemocracy;
    private String manufacturerId;
    private String engineManufacturerId;
    private String categoryId;

    public Product(String id, String name, String description, double price, int quantity, int engineNb, int seatNb, int serviceCeiling, boolean canSpreadDemocracy, String manufacturerId, String engineManufacturerId, String categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.engineNb = engineNb;
        this.seatNb = seatNb;
        this.serviceCeiling = serviceCeiling;
        this.canSpreadDemocracy = canSpreadDemocracy;
        this.manufacturerId = manufacturerId;
        this.engineManufacturerId = engineManufacturerId;
        this.categoryId = categoryId;
    }

    public Product(String name, String description, double price, int quantity, int engineNb, int seatNb, int serviceCeiling, boolean canSpreadDemocracy, String manufacturerId, String engineManufacturerId, String categoryId) {
        this(UUID.randomUUID().toString(), name, description, price, quantity, engineNb, seatNb, serviceCeiling, canSpreadDemocracy, manufacturerId, engineManufacturerId, categoryId);
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

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getEngineManufacturerId() {
        return engineManufacturerId;
    }

    public void setEngineManufacturerId(String engineManufacturerId) {
        this.engineManufacturerId = engineManufacturerId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        double price = this.getPrice();

        NumberFormat formatter = NumberFormat.getInstance(Locale.US);

        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);

        String formattedPrice = formatter.format(price);

        return String.format("Name : %s\n\nDescription : %s\n\nPrice : $%s\n\nQuantity : %d\n",
                             this.getName(), this.getDescription(), formattedPrice, this.getQuantity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(getPrice(), product.getPrice()) == 0 && getQuantity() == product.getQuantity() && getEngineNb() == product.getEngineNb() && getSeatNb() == product.getSeatNb() && getServiceCeiling() == product.getServiceCeiling() && canSpreadDemocracy == product.canSpreadDemocracy && Objects.equals(getId(), product.getId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getManufacturerId(), product.getManufacturerId()) && Objects.equals(getEngineManufacturerId(), product.getEngineManufacturerId()) && Objects.equals(getCategoryId(), product.getCategoryId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPrice(), getQuantity(), getEngineNb(), getSeatNb(), getServiceCeiling(), canSpreadDemocracy, getManufacturerId(), getEngineManufacturerId(), getCategoryId());
    }
}
