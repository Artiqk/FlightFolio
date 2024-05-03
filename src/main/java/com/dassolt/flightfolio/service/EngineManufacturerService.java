package com.dassolt.flightfolio.service;

import com.dassolt.flightfolio.dao.EngineManufacturerDAO;
import com.dassolt.flightfolio.model.EngineManufacturer;

import java.sql.SQLException;
import java.util.List;

public class EngineManufacturerService {
    private final EngineManufacturerDAO engineManufacturerDAO;

    public EngineManufacturerService(boolean isTestEnvironment) throws SQLException {
        engineManufacturerDAO = new EngineManufacturerDAO(isTestEnvironment);
    }

    public EngineManufacturerService() throws SQLException {
        engineManufacturerDAO = new EngineManufacturerDAO();
    }

    public void addEngineManufacturer(EngineManufacturer engineManufacturer) {
        if (engineManufacturer == null || engineManufacturer.getName() == null || engineManufacturer.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Engine manufacturer name cannot be empty");
        }

        try {
            engineManufacturerDAO.add(engineManufacturer);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add engine manufacturer due to a database error", e);
        }
    }

    public EngineManufacturer retrieveEngineManufacturerById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID parameter cannot be empty.");
        }

        try {
            return engineManufacturerDAO.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve engine manufacturer due to a database error", e);
        }
    }

    public List<EngineManufacturer> retrieveAllEngineManufacturers() {
        try {
            return engineManufacturerDAO.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve all engine manufacturers due to a database error", e);
        }
    }

    public void updateEngineManufacturer(EngineManufacturer engineManufacturer) {
        if (engineManufacturer == null || engineManufacturer.getId() == null) {
            throw new IllegalArgumentException("Engine manufacturer and its ID cannot be null.");
        }

        try {
            EngineManufacturer engineManufacturerToUpdate = engineManufacturerDAO.findById(engineManufacturer.getId());

            if (engineManufacturerToUpdate != null && !engineManufacturerToUpdate.equals(engineManufacturer)) {
                engineManufacturerDAO.update(engineManufacturer);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update engine manufacturer due to a database error", e);
        }
    }

    public void deleteEngineManufacturer(EngineManufacturer engineManufacturer) {
        if (engineManufacturer == null || engineManufacturer.getId() == null) {
            throw new IllegalArgumentException("Engine manufacturer and its ID cannot be null.");
        }

        try {
            engineManufacturerDAO.delete(engineManufacturer);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete engine manufacturer due to a database error", e);
        }
    }
}
