package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.util.DatabaseConnection;
import jdk.jshell.spi.ExecutionControl;

import java.sql.Connection;
import java.util.List;

public class CategoryDAO implements GenericDAO<CategoryDAO>{
    private Connection conn;

    public CategoryDAO() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (Exception e) {
            System.out.println("ERROR: @CategoryDAO" + e.getMessage());
        }
    }

    @Override
    public void add(CategoryDAO categoryDAO) {

    }

    @Override
    public CategoryDAO findById(int id) {
        return null;
    }

    @Override
    public List<CategoryDAO> findAll() {
        return List.of();
    }

    @Override
    public void save(CategoryDAO categoryDAO) {

    }

    @Override
    public void update(CategoryDAO categoryDAO) {

    }

    @Override
    public void delete(CategoryDAO categoryDAO) {

    }
}
