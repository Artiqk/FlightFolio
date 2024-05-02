package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.Product;
import com.dassolt.flightfolio.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
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
    public void add(Product product) throws SQLException {
        String query = "INSERT INTO product(name,description,price,quantity,engine_nb,seat_nb,wingspan,length,service_ceiling,can_spread_democracy,manufacturer_id,engine_manufacturer_id,category_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getQuantity());
            statement.setInt(5, product.getEngineNb());
            statement.setInt(6, product.getSeatNb());
            statement.setDouble(7, product.getWingspan());
            statement.setDouble(8, product.getLength());
            statement.setInt(9, product.getServiceCeiling());
            statement.setBoolean(10, product.canSpreadDemocracy());
            statement.setInt(11, product.getManufacturerId());
            statement.setInt(12, product.getEngineManufacturerId());
            statement.setInt(13, product.getCategoryId());
            statement.executeUpdate();
        }
    }

    @Override
    public Product findById(int id) throws SQLException {
        String query = "SELECT * FROM product WHERE id = ?";
        Product product = null;

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    product = extractProductFromResultSet(rs);
                }
            }
        }
        return product;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM product";
        try (Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                products.add(extractProductFromResultSet(rs));
            }
        }
        return products;
    }

    @Override
    public void update(Product product) throws SQLException {
        String query = "UPDATE product SET name=?, description=?, price=?, quantity=?, engine_nb=?, seat_nb=?, wingspan=?, length=?, service_ceiling=?, can_spread_democracy=?, manufacturer_id=?, engine_manufacturer_id=?, category_id=? WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getQuantity());
            statement.setInt(5, product.getEngineNb());
            statement.setInt(6, product.getSeatNb());
            statement.setDouble(7, product.getWingspan());
            statement.setDouble(8, product.getLength());
            statement.setInt(9, product.getServiceCeiling());
            statement.setBoolean(10, product.canSpreadDemocracy());
            statement.setInt(11, product.getManufacturerId());
            statement.setInt(12, product.getEngineManufacturerId());
            statement.setInt(13, product.getCategoryId());
            statement.setInt(14, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR: Failed to update product - " + e.getMessage());
        }
    }

    @Override
    public void delete(Product product) throws SQLException{
        String query = "DELETE FROM product WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, product.getId());
            statement.executeUpdate();
        }
    }

    private Product createProductFromResultSet(ResultSet rs) throws SQLException {
        return new Product(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getDouble("price"),
                rs.getInt("quantity"),
                rs.getInt("engine_nb"),
                rs.getInt("seat_nb"),
                rs.getDouble("wingspan"),
                rs.getDouble("length"),
                rs.getInt("service_ceiling"),
                rs.getBoolean("can_spread_democracy"),
                rs.getInt("manufacturer_id"),
                rs.getInt("engine_manufacturer_id"),
                rs.getInt("category_id")
        );
    }
}
