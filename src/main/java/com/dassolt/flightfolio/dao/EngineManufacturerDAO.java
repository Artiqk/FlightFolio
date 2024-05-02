package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.EngineManufacturer;
import com.dassolt.flightfolio.util.DatabaseConnection;

import java.sql.Connection;
import java.util.List;

public class EngineManufacturerDAO implements GenericDAO<EngineManufacturer> {
    private Connection conn;

    public EngineManufacturerDAO() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (Exception e) {
            System.out.println("ERROR: @EngineManufacturerDAO" + e.getMessage());
        }
    }

    @Override
    public void add(EngineManufacturer engineManufacturer) {

    }

    @Override
    public EngineManufacturer findById(int id) {
        return null;
    }

    @Override
    public List<EngineManufacturer> findAll() {
        return List.of();
    }

    @Override
    public void update(EngineManufacturer engineManufacturer) {

    }

    @Override
    public void delete(EngineManufacturer engineManufacturer) {

    }
}
