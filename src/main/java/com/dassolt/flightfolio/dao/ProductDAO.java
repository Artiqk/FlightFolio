package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.Product;
import com.dassolt.flightfolio.util.DatabaseConnection;

import java.sql.*;
import java.util.List;

public class ProductDAO implements GenericDAO<Product> {
    private Connection conn;

    public ProductDAO() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (Exception e) {
            System.out.println("ERROR: @ProductDAO" + e.getMessage());
        }
    }

    @Override
    public void add(Product product) {
        String query = "INSERT INTO product(name,description,price,quantity,engine_nb,seat_nb,wingspan,length,service_ceiling,can_spread_democracy,manufacturer_id,engine_manufacturer_id,category_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            conn.setAutoCommit(false);

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getQuantity());
            stmt.setInt(5, product.getEngineNb());
            stmt.setInt(6, product.getSeatNb());
            stmt.setDouble(7, product.getWingspan());
            stmt.setDouble(8, product.getLength());
            stmt.setInt(9, product.getServiceCeiling());
            stmt.setBoolean(10, product.canSpreadDemocracy());
            stmt.setInt(11, product.getManufacturerId());
            stmt.setInt(12, product.getEngineManufacturerId());
            stmt.setInt(13, product.getCategoryId());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                product.setId(rs.getInt(1));
            }

            conn.commit();
        } catch (SQLException e) {
            try {
                if (!(conn == null || conn.isClosed())) conn.rollback();
            } catch (SQLException ex) {
                System.out.println("ERROR: Failed to rollback transaction - " + ex.getMessage());
            }
            System.out.println("ERROR: Failed to add product to the database - " + e.getMessage());
        } finally {
            try {
                if (!(conn == null || conn.isClosed())) conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("ERROR: Could not reset auto-commit - " + e.getMessage());
            }
        }
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }
}
