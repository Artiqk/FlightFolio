package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.EngineManufacturer;
import static org.junit.jupiter.api.Assertions.*;

import com.dassolt.flightfolio.util.DatabaseConnection;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EngineManufacturerDAOTest {
    private static EngineManufacturerDAO dao;
    private static EngineManufacturer generalElectric;
    private static EngineManufacturer rollsRoyce;

    @BeforeAll
    public static void setup() throws SQLException {
        dao = new EngineManufacturerDAO(true);
        generalElectric = new EngineManufacturer("7b8af0ad-b740-4638-bd6f-a48f84b18782", "General Electric");
        rollsRoyce = new EngineManufacturer("Rolls-Royce");
    }

    @Test
    @Order(1)
    public void createTest() throws SQLException {
        dao.add(generalElectric);
        dao.add(rollsRoyce);

        assertNotNull(dao.findById(generalElectric.getId()), "The object must be found in the database");
        assertNotNull(dao.findById(rollsRoyce.getId()), "The object must be found in the database");
    }

    @Test
    @Order(2)
    public void readAllTest() throws SQLException {
        assertEquals(2, dao.findAll().size(), "The size of the list should be equal to 2.");
    }

    @Test
    @Order(3)
    public void readIdTest() throws SQLException {
        assertEquals(generalElectric, dao.findById(generalElectric.getId()), "The 2 objects must be identical.");
        assertEquals(rollsRoyce, dao.findById(rollsRoyce.getId()), "The 2 objects must be identical.");
    }

    @Test
    @Order(4)
    public void updateTest() throws SQLException {
        final String newName = "General Electric";
        generalElectric.setName(newName);
        dao.update(generalElectric);
        assertEquals(newName, dao.findById(generalElectric.getId()).getName(), "The name in the database must be equal to the new name");
    }

    @Test
    @Order(5)
    public void deleteTest() throws SQLException {
        dao.delete(generalElectric);
        assertNull(dao.findById(generalElectric.getId()), "The returned object must be null after delete");
        dao.delete(rollsRoyce);
        assertTrue(dao.findAll().isEmpty(), "The list must be empty after all rows are deleted from the database");
    }

    @AfterAll
    public static void finish() throws SQLException {
        DatabaseConnection.getConnection().close();
    }
}
