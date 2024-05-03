package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.Category;
import com.dassolt.flightfolio.util.DatabaseConnection;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoryDAOTest {
    private static CategoryDAO dao;
    private static Category commercial;
    private static Category military;

    @BeforeAll
    public static void setup() throws SQLException {
        dao = new CategoryDAO(true);
        commercial = new Category("Commercial");
        military = new Category("Military");
    }

    @Test
    @Order(1)
    public void createTest() throws SQLException {
        dao.add(commercial);
        dao.add(military);

        assertNotNull(dao.findById(commercial.getId()), "The object must be found in the database");
        assertNotNull(dao.findById(military.getId()), "The object must be found in the database");
    }

    @Test
    @Order(2)
    public void readAllTest() throws SQLException {
        assertEquals(2, dao.findAll().size(), "The size of the list should be equal to 2.");
    }

    @Test
    @Order(3)
    public void readIdTest() throws SQLException {
        assertEquals(commercial, dao.findById(commercial.getId()), "The 2 objects must be identical.");
        assertEquals(military, dao.findById(military.getId()), "The 2 objects must be identical.");
    }

    @Test
    @Order(4)
    public void updateTest() throws SQLException {
        final String newName = "Private";
        commercial.setName(newName);
        dao.update(commercial);
        assertEquals(newName, dao.findById(commercial.getId()).getName(), "The name in the database must be equal to the new name");
    }

    @Test
    @Order(5)
    public void deleteTest() throws SQLException {
        dao.delete(commercial);
        assertNull(dao.findById(commercial.getId()), "The returned object must be null after delete");
        dao.delete(military);
        assertTrue(dao.findAll().isEmpty(), "The list must be empty after all rows are deleted from the database");
    }

    @AfterAll
    public static void finish() throws SQLException {
        DatabaseConnection.getConnection().close();
    }
}
