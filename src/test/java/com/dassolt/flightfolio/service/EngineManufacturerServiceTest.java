package com.dassolt.flightfolio.service;

import com.dassolt.flightfolio.model.EngineManufacturer;
import com.dassolt.flightfolio.util.DatabaseConnection;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EngineManufacturerServiceTest {
    private static EngineManufacturerService service;
    private static EngineManufacturer ge;

    @BeforeAll
    public static void setup() throws SQLException {
        ge = new EngineManufacturer("General Electric");
        service = new EngineManufacturerService(true); // Assuming the constructor does not require parameters
    }

    @Test
    @Order(1)
    public void createTest() {
        service.addEngineManufacturer(ge);
        assertEquals(ge, service.retrieveEngineManufacturerById(ge.getId()), "The object must be identical to the one created in the database.");
    }

    @Test
    @Order(2)
    public void retrieveAllEngineManufacturersTest() {
        assertEquals(1, service.retrieveAllEngineManufacturers().size(), "The total number of objects must be equal to 1.");
    }

    @Test
    @Order(3)
    public void retrieveEngineManufacturerByIdTest() {
        assertEquals(ge, service.retrieveEngineManufacturerById(ge.getId()), "The 2 objects must be identical.");
    }

    @Test
    @Order(4)
    public void updateEngineManufacturerTest() {
        final String newName = "GE Aviation";
        ge.setName(newName);
        service.updateEngineManufacturer(ge);
        assertEquals(newName, service.retrieveEngineManufacturerById(ge.getId()).getName(), "The name in the database must be equal to the new name.");
    }

    @Test
    @Order(5)
    public void deleteEngineManufacturerTest() {
        service.deleteEngineManufacturer(ge);
        assertTrue(service.retrieveAllEngineManufacturers().isEmpty(), "The list must be empty after all rows are deleted from the database.");
    }

    @AfterAll
    public static void finish() throws SQLException {
        DatabaseConnection.getConnection().close();
    }
}
