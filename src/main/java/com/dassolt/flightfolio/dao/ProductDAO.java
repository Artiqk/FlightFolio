package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.Product;
import com.dassolt.flightfolio.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
        String query = "INSERT INTO product(id,name,description,price,quantity,engine_nb,seat_nb,wingspan,length,service_ceiling,can_spread_democracy,manufacturer_id,engine_manufacturer_id,category_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, product.getId());
            stmt.setString(2, product.getName());
            stmt.setString(3, product.getDescription());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, product.getQuantity());
            stmt.setInt(6, product.getEngineNb());
            stmt.setInt(7, product.getSeatNb());
            stmt.setDouble(8, product.getWingspan());
            stmt.setDouble(9, product.getLength());
            stmt.setInt(10, product.getServiceCeiling());
            stmt.setBoolean(11, product.isCanSpreadDemocracy());
            stmt.setInt(12, product.getManufacturerId());
            stmt.setInt(13, product.getEngineManufacturerId());
            stmt.setInt(14, product.getCategoryId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: Failed to add product to the database - " + e.getMessage());
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
    public void save(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }
}
