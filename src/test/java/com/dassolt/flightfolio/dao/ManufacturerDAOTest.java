package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.Manufacturer;
import static org.junit.jupiter.api.Assertions.*;

import com.dassolt.flightfolio.util.DatabaseConnection;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ManufacturerDAOTest {
    private static ManufacturerDAO dao;
    private static Manufacturer lockheedMartin;
    private static Manufacturer dassault;

    @BeforeAll
    public static void setup() throws SQLException {
        dao = new ManufacturerDAO(true);
        dassault = new Manufacturer("0c78ca45-6ef8-4d5a-996c-7ca3de9b4f37", "Dassault");
        lockheedMartin = new Manufacturer("Lockheed Martin");
    }

    @Test
    @Order(1)
    public void createTest() throws SQLException {
        dao.add(lockheedMartin);
        dao.add(dassault);

        assertNotNull(dao.findById(lockheedMartin.getId()), "The object must be found in the database");
        assertNotNull(dao.findById(dassault.getId()), "The object must be found in the database");
    }

    @Test
    @Order(2)
    public void readAllTest() throws SQLException {
        assertEquals(2, dao.findAll().size(), "The size of the list should be equal to 2.");
    }

    @Test
    @Order(3)
    public void readIdTest() throws SQLException {
        assertEquals(lockheedMartin, dao.findById(lockheedMartin.getId()), "The 2 objects must be identical.");
        assertEquals(dassault, dao.findById(dassault.getId()), "The 2 objects must be identical.");
    }

    @Test
    @Order(4)
    public void updateTest() throws SQLException {
        final String newName = "Lockhead Martin";
        lockheedMartin.setName(newName);
        dao.update(lockheedMartin);
        assertEquals(newName, dao.findById(lockheedMartin.getId()).getName(), "The name in the database must be equal to the new name.");
    }

    @Test
    @Order(5)
    public void deleteTest() throws SQLException {
        dao.delete(lockheedMartin);
        assertNull(dao.findById(lockheedMartin.getId()), "The returned object must be null after delete.");
        dao.delete(dassault);
        assertTrue(dao.findAll().isEmpty(), "The list must be empty after all rows have been deleted from the database.");
    }

    @AfterAll
    public static void finish() throws SQLException {
        DatabaseConnection.getConnection().close();
    }
}
