package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.Manufacturer;
import com.dassolt.flightfolio.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDAO implements GenericDAO<Manufacturer> {
    private final Connection conn;

    public ManufacturerDAO() throws SQLException {
        conn = DatabaseConnection.getConnection();
    }

    private Manufacturer createManufacturerFromResultSet(ResultSet rs) throws SQLException {
        return new Manufacturer(
                rs.getString("id"),
                rs.getString("name")
        );
    }

    @Override
    public void add(Manufacturer manufacturer) throws SQLException {
        String query = "INSERT INTO manufacturer(id, name) VALUES(?,?)";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, manufacturer.getId());
            statement.setString(2, manufacturer.getName());
            statement.executeUpdate();
        }
    }

    @Override
    public Manufacturer findById(String id) throws SQLException {
        String query = "SELECT * FROM manufacturer WHERE id = ?";
        Manufacturer manufacturer = null;

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                manufacturer = createManufacturerFromResultSet(rs);
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
        String query = "UPDATE manufacturer SET name = ? WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, manufacturer.getName());
            statement.setString(2, manufacturer.getId());
        }
    }

    @Override
    public void delete(Manufacturer manufacturer) throws SQLException {
        String query = "DELETE FROM product WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, manufacturer.getId());
            statement.executeUpdate();
        }
    }
}
