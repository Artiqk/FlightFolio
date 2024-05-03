package com.dassolt.flightfolio.service;

import com.dassolt.flightfolio.dao.ManufacturerDAO;
import com.dassolt.flightfolio.model.Manufacturer;

import java.sql.SQLException;
import java.util.List;

public class ManufacturerService {
    private final ManufacturerDAO manufacturerDAO;

    public ManufacturerService(boolean isTestEnvironment) throws SQLException {
        manufacturerDAO = new ManufacturerDAO(isTestEnvironment);
    }

    public ManufacturerService() throws SQLException {
        manufacturerDAO = new ManufacturerDAO();
    }

    public void addManufacturer(Manufacturer manufacturer) {
        if (manufacturer == null || manufacturer.getName() == null || manufacturer.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Manufacturer name cannot be empty");
        }

        try {
            manufacturerDAO.add(manufacturer);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add manufacturer due to a database error", e);
        }
    }

    public Manufacturer retrieveManufacturerById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID parameter cannot be empty.");
        }

        try {
            return manufacturerDAO.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve manufacturer due to a database error", e);
        }
    }

    public List<Manufacturer> retrieveAllManufacturers() {
        try {
            return manufacturerDAO.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve all manufacturers due to a database error", e);
        }
    }

    public void updateManufacturer(Manufacturer manufacturer) {
        try {
            Manufacturer manufacturerToUpdate = manufacturerDAO.findById(manufacturer.getId());

            if (manufacturerToUpdate != null && !manufacturerToUpdate.equals(manufacturer)) {
                manufacturerDAO.update(manufacturer);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update manufacturer due to a database error", e);
        }
    }

    public void deleteManufacturer(Manufacturer manufacturer) {
        if (manufacturer == null || manufacturer.getId() == null) {
            throw new IllegalArgumentException("Manufacturer and its ID cannot be null.");
        }

        try {
            manufacturerDAO.delete(manufacturer);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete manufacturer due to a database error", e);
        }
    }
}
