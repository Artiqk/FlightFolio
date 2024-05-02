package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.Manufacturer;
import com.dassolt.flightfolio.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public void add(Manufacturer manufacturer) throws SQLException {
        String query = "INSERT INTO manufacturer(name) VALUES(?)";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, manufacturer.getName());
            statement.executeUpdate();
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
    public void update(Manufacturer manufacturer) {

    }

    @Override
    public void delete(Manufacturer manufacturer) {

    }
}
