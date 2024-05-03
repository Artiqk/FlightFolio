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
        if (category == null || category.getName() == null || category.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be empty");
        }

        try {
            categoryDAO.add(category);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add category due to a database error", e);
        }
    }

    public Category retrieveCategoryById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID parameter cannot be empty.");
        }

        try {
            return categoryDAO.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve category due to a database error", e);
        }
    }

    public List<Category> retrieveAllCategories() {
        try {
            return categoryDAO.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve all categories due to a database error", e);
        }
    }

    public void updateCategory(Category category) {
        if (category == null || category.getId() == null) {
            throw new IllegalArgumentException("Category and its ID cannot be null.");
        }

        try {
            Category categoryToUpdate = categoryDAO.findById(category.getId());

            if (categoryToUpdate != null && !categoryToUpdate.equals(category)) {
                categoryDAO.update(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update category due to a database error", e);
        }
    }

    public void deleteCategory(Category category) {
        if (category == null || category.getId() == null) {
            throw new IllegalArgumentException("Category and its ID cannot be null.");
        }

        try {
            categoryDAO.delete(category);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete category due to a database error", e);
        }
    }
}
