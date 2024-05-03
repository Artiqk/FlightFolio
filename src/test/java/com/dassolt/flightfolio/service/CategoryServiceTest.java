package com.dassolt.flightfolio.service;

import com.dassolt.flightfolio.model.Category;
import com.dassolt.flightfolio.util.DatabaseConnection;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoryServiceTest {
    private static CategoryService service;
    private static Category commercial;

    @BeforeAll
    public static void setup() throws SQLException {
        commercial = new Category("Commercial");
        service = new CategoryService(true); // Assuming true indicates a test environment
    }

    @Test
    @Order(1)
    public void createTest() {
        service.addCategory(commercial);
        assertEquals(commercial, service.retrieveCategoryById(commercial.getId()), "The object must be identical to the one created in the database.");
    }

    @Test
    @Order(2)
    public void retrieveAllCategoriesTest() {
        assertEquals(1, service.retrieveAllCategories().size(), "The total number of categories must be equal to 1.");
    }

    @Test
    @Order(3)
    public void retrieveCategoryByIdTest() {
        assertEquals(commercial, service.retrieveCategoryById(commercial.getId()), "The 2 objects must be identical.");
    }

    @Test
    @Order(4)
    public void updateCategoryTest() {
        final String newName = "Commercial Sector";
        commercial.setName(newName);
        service.updateCategory(commercial);
        assertEquals(newName, service.retrieveCategoryById(commercial.getId()).getName(), "The name in the database must be equal to the new name.");
    }

    @Test
    @Order(5)
    public void deleteCategoryTest() {
        service.deleteCategory(commercial);
        assertNull(service.retrieveCategoryById(commercial.getId()), "The returned object must be null after deletion.");
    }

    @AfterAll
    public static void finish() throws SQLException {
        DatabaseConnection.getConnection().close();
    }
}
