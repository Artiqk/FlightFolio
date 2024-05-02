package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.EngineManufacturer;
import com.dassolt.flightfolio.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EngineManufacturerDAO implements GenericDAO<EngineManufacturer> {
    private final Connection conn;

    public EngineManufacturerDAO() throws SQLException {
        conn = DatabaseConnection.getConnection();
    }

    @Override
    public void add(EngineManufacturer engineManufacturer) {

    }

    @Override
    public EngineManufacturer findById(String id) {
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
