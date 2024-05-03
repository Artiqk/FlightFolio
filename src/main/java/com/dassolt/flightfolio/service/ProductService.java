package com.dassolt.flightfolio.service;

import com.dassolt.flightfolio.dao.ProductDAO;
import com.dassolt.flightfolio.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(boolean isTestEnvironment) throws SQLException {
        productDAO = new ProductDAO(isTestEnvironment);
    }

    public ProductService() throws SQLException {
        productDAO = new ProductDAO();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        validateProduct(product);

        try {
            productDAO.add(product);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add product due to a database error", e);
        }
    }

    public Product retrieveProductById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be empty.");
        }

        try {
            return productDAO.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve product due to a database error", e);
        }
    }

    public List<Product> retrieveAllProducts() {
        try {
            return productDAO.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve all products due to a database error", e);
        }
    }

    public void updateProduct(Product product) {
        if (product == null || product.getId() == null) {
            throw new IllegalArgumentException("Product and its ID cannot be null.");
        }
        validateProduct(product);

        try {
            productDAO.update(product);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update product due to a database error", e);
        }
    }

    public void deleteProduct(Product product) {
        if (product == null || product.getId() == null) {
            throw new IllegalArgumentException("Product and its ID cannot be null.");
        }

        try {
            productDAO.delete(product);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete product due to a database error", e);
        }
    }

    private void validateProduct(Product product) {
        if (product.getName() == null || product.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        if (product.getManufacturerId() == null || product.getEngineManufacturerId() == null) {
            throw new IllegalArgumentException("Manufacturer and Engine Manufacturer IDs cannot be null.");
        }
        // Additional validations can be included based on business requirements
    }
}
