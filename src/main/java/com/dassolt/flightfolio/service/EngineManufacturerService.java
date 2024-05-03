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
        try {
            engineManufacturerDAO.add(engineManufacturer);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add engine manufacturer due to a database error", e);
        }
    }

    public EngineManufacturer retrieveEngineManufacturerById(String id) {
        EngineManufacturer engineManufacturer = null;

        try {
            engineManufacturer = engineManufacturerDAO.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve engine manufacturer due to a database error", e);
        }

        return engineManufacturer;
    }

    public List<EngineManufacturer> retrieveAllEngineManufacturers() {
        List<EngineManufacturer> engineManufacturers = null;

        try {
            engineManufacturers = engineManufacturerDAO.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve all engine manufacturers due to a database error", e);
        }

        return engineManufacturers;
    }

    public void updateEngineManufacturer(EngineManufacturer engineManufacturer) {
        try {
            engineManufacturerDAO.update(engineManufacturer);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update engine manufacturer due to a database error", e);
        }
    }

    public void deleteEngineManufacturer(EngineManufacturer engineManufacturer) {
        try {
            engineManufacturerDAO.delete(engineManufacturer);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete engine manufacturer due to a database error", e);
        }
    }
}
