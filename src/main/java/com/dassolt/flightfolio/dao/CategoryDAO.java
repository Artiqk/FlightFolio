package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.Category;
import com.dassolt.flightfolio.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements GenericDAO<Category>{
    private final Connection conn;

    public CategoryDAO() throws SQLException {
        conn = DatabaseConnection.getConnection();
    }

    private Category createCategoryFromResultSet(ResultSet rs) throws SQLException {
        return new Category(
                rs.getString("id"),
                rs.getString("name")
        );
    }

    @Override
    public void add(Category category) throws SQLException {
        String query = "INSERT INTO category(id, name) VALUES(?,?)";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, category.getId());
            statement.setString(2, category.getName());
            statement.executeUpdate();
        }
    }

    @Override
    public Category findById(String id) throws SQLException {
        String query = "SELECT * FROM category WHERE id = ?";
        Category category = null;

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    category = createCategoryFromResultSet(rs);
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
                Category category = createCategoryFromResultSet(rs);
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
            statement.setString(2, category.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Category category) throws SQLException {
        String query = "DELETE FROM category WHERE id = ?";

        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, category.getId());
            statement.executeUpdate();
        }
    }

}
