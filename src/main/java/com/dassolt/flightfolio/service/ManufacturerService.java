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
        try {
            manufacturerDAO.add(manufacturer);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add manufacturer due to a database error", e);
        }
    }

    public Manufacturer retrieveManufacturerById(String id) {
        Manufacturer manufacturer = null;

        try {
            manufacturer = manufacturerDAO.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve manufacturer due to a database error", e);
        }

        return manufacturer;
    }

    public List<Manufacturer> retrieveAllManufacturers() {
        List<Manufacturer> manufacturers = null;

        try {
            manufacturers = manufacturerDAO.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve all manufacturers due to a database error", e);
        }

        return manufacturers;
    }

    public void updateManufacturer(Manufacturer manufacturer) {
        try {
            manufacturerDAO.update(manufacturer);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update manufacturer due to a database error", e);
        }
    }

    public void deleteManufacturer(Manufacturer manufacturer) {
        try {
            manufacturerDAO.delete(manufacturer);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete manufacturer due to a database error", e);
        }
    }
}
