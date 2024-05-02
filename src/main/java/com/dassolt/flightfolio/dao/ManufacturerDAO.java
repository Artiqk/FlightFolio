package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.Manufacturer;
import com.dassolt.flightfolio.util.DatabaseConnection;

import java.sql.Connection;
import java.util.List;

public class ManufacturerDAO implements GenericDAO<Manufacturer> {
    private Connection conn;

    public ManufacturerDAO() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (Exception e) {
            System.out.println("ERROR: @ManufacturerDAO" + e.getMessage());
        }
    }
    @Override
    public Manufacturer findById(int id) {
        return null;
    }

    @Override
    public List<Manufacturer> findAll() {
        return List.of();
    }

    @Override
    public void save(Manufacturer manufacturer) {

    }

    @Override
    public void update(Manufacturer manufacturer) {

    }

    @Override
    public void delete(Manufacturer manufacturer) {

    }
}
