package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.Category;
import com.dassolt.flightfolio.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements GenericDAO<Category>{
    private Connection conn;

    public CategoryDAO() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (Exception e) {
            System.out.println("ERROR: @CategoryDAO" + e.getMessage());
        }
    }

    @Override
    public void add(Category category) throws SQLException {
        String query = "INSERT INTO category(name) VALUES(?)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, category.getName());
            statement.executeUpdate();
        }
    }

    @Override
    public Category findById(int id) throws SQLException {
        String query = "SELECT * FROM category WHERE id = ?";
        Category category = null;

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    category = extractCategoryFromResultSet(rs);
                }
            }
        }

        return category;
    }

    @Override
    public List<Category> findAll() throws SQLException {
        String query = "SELECT * FROM category";
        List<Category> categories = new ArrayList<>();

        try (Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                Category category = extractCategoryFromResultSet(rs);
                categories.add(category);
            }
        }

        return categories;
    }

    @Override
    public void update(Category category) throws SQLException {
        String query = "UPDATE category SET name = ? WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, category.getName());
            statement.setInt(2, category.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Category category) throws SQLException {
        String query = "DELETE FROM category WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, category.getId());
            statement.executeUpdate();
        }
    }

    private Category extractCategoryFromResultSet(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setId(rs.getInt("id"));
        category.setName(rs.getString("name"));
        return category;
    }
}
