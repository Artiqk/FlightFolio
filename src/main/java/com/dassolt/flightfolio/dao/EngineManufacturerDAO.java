package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.EngineManufacturer;
import com.dassolt.flightfolio.util.DatabaseConnection;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EngineManufacturerDAO implements GenericDAO<EngineManufacturer> {
    private final Connection conn;

    public EngineManufacturerDAO(boolean isTestEnvironment) throws SQLException {
        conn = DatabaseConnection.getConnection(isTestEnvironment);
    }

    public EngineManufacturerDAO() throws SQLException {
        conn = DatabaseConnection.getConnection();
    }

    private EngineManufacturer createEngineManufacturerFromResultSet(ResultSet rs) throws SQLException {
        return new EngineManufacturer(
                rs.getString("id"),
                rs.getString("name")
        );
    }

    @Override
    public void add(EngineManufacturer engineManufacturer) throws SQLException {
        String query = "INSERT INTO engine_manufacturer(id, name) VALUES(?,?)";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, engineManufacturer.getId());
            statement.setString(2, engineManufacturer.getName());
            statement.executeUpdate();
        }
    }

    @Override
    public EngineManufacturer findById(String id) throws SQLException {
        String query = "SELECT * FROM engine_manufacturer WHERE id = ?";
        EngineManufacturer engineManufacturer = null;

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                engineManufacturer = createEngineManufacturerFromResultSet(rs);
            }
        }

        return engineManufacturer;
    }

    @Override
    public List<EngineManufacturer> findAll() throws SQLException {
        List<EngineManufacturer> engineManufacturer = new ArrayList<>();
        String query = "SELECT * FROM engine_manufacturer";

        try (Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                engineManufacturer.add(createEngineManufacturerFromResultSet(rs));
            }
        }

        return engineManufacturer;
    }

    @Override
    public void update(EngineManufacturer engineManufacturer) throws SQLException {
        String query = "UPDATE engine_manufacturer SET name = ? WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, engineManufacturer.getName());
            statement.setString(2, engineManufacturer.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(EngineManufacturer engineManufacturer) throws SQLException {
        String query = "DELETE FROM engine_manufacturer WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, engineManufacturer.getId());
            statement.executeUpdate();
        }
    }
}
