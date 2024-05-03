package com.dassolt.flightfolio.service;

import com.dassolt.flightfolio.model.Manufacturer;
import com.dassolt.flightfolio.util.DatabaseConnection;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ManufacturerServiceTest {
    private static ManufacturerService service;
    private static Manufacturer boeing;

    @BeforeAll
    public static void setup() throws SQLException {
        boeing = new Manufacturer("Boeing");
        service = new ManufacturerService(true);
    }

    @Test
    @Order(1)
    public void createTest() {
        service.addManufacturer(boeing);

        assertEquals(boeing, service.retrieveManufacturerById(boeing.getId()), "The object must be identical to the one created in the database.");
    }

    @Test
    @Order(2)
    public void retrieveAllManufacturersTest() {
        assertEquals(1, service.retrieveAllManufacturers().size(), "The total number of objects must be equal to 1.");
    }

    @Test
    @Order(3)
    public void retrieveManufacturerByIdTest() {
        assertEquals(boeing, service.retrieveManufacturerById(boeing.getId()), "The 2 objects must be identical.");
    }

    @Test
    @Order(4)
    public void updateManufacturerTest() {
        final String newName = "Boing";
        boeing.setName(newName);
        service.updateManufacturer(boeing);
        assertEquals(newName, service.retrieveManufacturerById(boeing.getId()).getName(), "The name in the database must be equal to the new name.");
    }

    @Test
    @Order(5)
    public void deleteManufacturerTest() {
        service.deleteManufacturer(boeing);
        assertTrue(service.retrieveAllManufacturers().isEmpty());
    }

    @AfterAll
    public static void finish() throws SQLException {
        DatabaseConnection.getConnection().close();
    }
}
