package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.Manufacturer;
import com.dassolt.flightfolio.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
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

    private Manufacturer createManufacturerFromResultSet(ResultSet rs) throws SQLException {
        return new Manufacturer(
                rs.getInt("id"),
                rs.getString("name")
        );
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
    public Manufacturer findById(int id) throws SQLException {
        String query = "SELECT * FROM manufacturer WHERE id = ?";
        Manufacturer manufacturer = null;

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                manufacturer = new Manufacturer(id, name);
            }
        }

        return manufacturer;
    }

    @Override
    public List<Manufacturer> findAll() throws SQLException {
        List<Manufacturer> manufacturers = new ArrayList<>();
        String query = "SELECT * FROM manufacturer";

        try (Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                manufacturers.add(createManufacturerFromResultSet(rs));
            }
        }

        return manufacturers;
    }

    @Override
    public void update(Manufacturer manufacturer) throws SQLException {
        String query = "UPDATE manufacturer SET name=?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, manufacturer.getName());
        }
    }

    @Override
    public void delete(Manufacturer manufacturer) throws SQLException {
        String query = "DELETE FROM product WHERE id=?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, manufacturer.getId());
            statement.executeUpdate();
        }
    }
}
