package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.Product;
import com.dassolt.flightfolio.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements GenericDAO<Product> {
    private final Connection conn;

    public ProductDAO(boolean isTestEnvironment) throws SQLException {
        conn = DatabaseConnection.getConnection(isTestEnvironment);
    }

    public ProductDAO() throws SQLException {
        conn = DatabaseConnection.getConnection();
    }

    private Product createProductFromResultSet(ResultSet rs) throws SQLException {
        return new Product(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getDouble("price"),
                rs.getInt("quantity"),
                rs.getInt("engine_nb"),
                rs.getInt("seat_nb"),
                rs.getInt("service_ceiling"),
                rs.getBoolean("can_spread_democracy"),
                rs.getString("manufacturer_id"),
                rs.getString("engine_manufacturer_id"),
                rs.getString("category_id")
        );
    }

    @Override
    public void add(Product product) throws SQLException {
        String query = "INSERT INTO product(id,name,description,price,quantity,engine_nb,seat_nb,service_ceiling,can_spread_democracy,manufacturer_id,engine_manufacturer_id,category_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, product.getId());
            statement.setString(2, product.getName());
            statement.setString(3, product.getDescription());
            statement.setDouble(4, product.getPrice());
            statement.setInt(5, product.getQuantity());
            statement.setInt(6, product.getEngineNb());
            statement.setInt(7, product.getSeatNb());
            statement.setInt(8, product.getServiceCeiling());
            statement.setBoolean(9, product.canSpreadDemocracy());
            statement.setString(10, product.getManufacturerId());
            statement.setString(11, product.getEngineManufacturerId());
            statement.setString(12, product.getCategoryId());
            statement.executeUpdate();
        }
    }

    @Override
    public Product findById(String id) throws SQLException {
        String query = "SELECT * FROM product WHERE id = ?";
        Product product = null;

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    product = createProductFromResultSet(rs);
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
                products.add(createProductFromResultSet(rs));
            }
        }

        return products;
    }

    @Override
    public void update(Product product) throws SQLException {
        String query = "UPDATE product SET name = ?, description = ?, price = ?, quantity = ?, engine_nb = ?, seat_nb = ?, service_ceiling = ?, can_spread_democracy = ?, manufacturer_id = ?, engine_manufacturer_id = ?, category_id = ? WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getQuantity());
            statement.setInt(5, product.getEngineNb());
            statement.setInt(6, product.getSeatNb());
            statement.setInt(7, product.getServiceCeiling());
            statement.setBoolean(8, product.canSpreadDemocracy());
            statement.setString(9, product.getManufacturerId());
            statement.setString(10, product.getEngineManufacturerId());
            statement.setString(11, product.getCategoryId());
            statement.setString(12, product.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Product product) throws SQLException{
        String query = "DELETE FROM product WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, product.getId());
            statement.executeUpdate();
        }
    }

}
