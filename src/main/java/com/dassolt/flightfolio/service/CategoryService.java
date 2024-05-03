package com.dassolt.flightfolio.service;

import com.dassolt.flightfolio.dao.CategoryDAO;
import com.dassolt.flightfolio.model.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    private final CategoryDAO categoryDAO;

    public CategoryService(boolean isTestEnvironment) throws SQLException {
        categoryDAO = new CategoryDAO(isTestEnvironment);
    }

    public CategoryService() throws SQLException {
        categoryDAO = new CategoryDAO();
    }

    public void addCategory(Category category) {
        try {
            categoryDAO.add(category);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add category due to a database error", e);
        }
    }

    public Category retrieveCategoryById(String id) {
        Category category = null;

        try {
            category = categoryDAO.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve category due to a database error", e);
        }

        return category;
    }

    public List<Category> retrieveAllCategories() {
        List<Category> categories = null;

        try {
            categories = categoryDAO.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve all categories due to a database error", e);
        }

        return categories;
    }

    public void updateCategory(Category category) {
        try {
            categoryDAO.update(category);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update category due to a database error", e);
        }
    }

    public void deleteCategory(Category category) {
        try {
            categoryDAO.delete(category);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete category due to a database error", e);
        }
    }
}