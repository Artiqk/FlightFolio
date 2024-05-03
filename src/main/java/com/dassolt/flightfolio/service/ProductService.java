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
        try {
            productDAO.add(product);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add product due to a database error", e);
        }
    }

    public Product retrieveProductById(String id) {
        Product product = null;
        try {
            product = productDAO.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve product due to a database error", e);
        }
        return product;
    }

    public List<Product> retrieveAllProducts() {
        List<Product> products = null;
        try {
            products = productDAO.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve all products due to a database error", e);
        }
        return products;
    }

    public void updateProduct(Product product) {
        try {
            productDAO.update(product);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update product due to a database error", e);
        }
    }

    public void deleteProduct(Product product) {
        try {
            productDAO.delete(product);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete product due to a database error", e);
        }
    }
}
