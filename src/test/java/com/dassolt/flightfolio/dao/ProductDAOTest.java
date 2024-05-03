package com.dassolt.flightfolio.dao;

import com.dassolt.flightfolio.model.Category;
import com.dassolt.flightfolio.model.EngineManufacturer;
import com.dassolt.flightfolio.model.Manufacturer;
import com.dassolt.flightfolio.model.Product;
import com.dassolt.flightfolio.util.DatabaseConnection;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductDAOTest {
    private static ProductDAO productDAO;

    private static Category military;
    private static Manufacturer dassault;
    private static EngineManufacturer safran;
    private static Product rafaleM;

    private static final boolean useTestEnvironment = true;

    @BeforeAll
    public static void setup() throws SQLException {
        productDAO = new ProductDAO(useTestEnvironment);

        military = new Category("Military");
        dassault = new Manufacturer("Dassault");
        safran = new EngineManufacturer("Safran");
        rafaleM = new Product("Rafale M", "A powerful and agile multirole fighter, equipped to operate from aircraft carriers and meet various mission requirements.", 74000000.00, 9, 2, 1, 15235, true, dassault.getId(), safran.getId(), military.getId());

        new CategoryDAO(useTestEnvironment).add(military);
        new ManufacturerDAO(useTestEnvironment).add(dassault);
        new EngineManufacturerDAO(useTestEnvironment).add(safran);
    }

    @Test
    @Order(1)
    public void createTest() throws SQLException {
        productDAO.add(rafaleM);

        assertNotNull(productDAO.findById(rafaleM.getId()), "The object must be found in the database.");
    }

    @Test
    @Order(2)
    public void readAllTest() throws SQLException {
        assertEquals(1, productDAO.findAll().size(), "The size of the list should be equal to 1.");
    }

    @Test
    @Order(3)
    public void readIdTest() throws SQLException {
        assertEquals(rafaleM, productDAO.findById(rafaleM.getId()), "The 2 objects must be identical.");
    }

    @Test
    @Order(4)
    public void updateTest() throws SQLException {
        final String newName = "Rafale Mc Queen";
        final boolean newDemocracy = false;

        rafaleM.setName(newName);
        rafaleM.setCanSpreadDemocracy(newDemocracy);

        productDAO.update(rafaleM);

        assertEquals(newName, productDAO.findById(rafaleM.getId()).getName(), "The name in the database must be equal to the new name.");
        assertFalse(productDAO.findById(rafaleM.getId()).canSpreadDemocracy(), "The jet fighter must not be able to spread democracy.");
    }

    @Test
    @Order(5)
    public void deleteTest() throws SQLException {
        productDAO.delete(rafaleM);
        assertTrue(productDAO.findAll().isEmpty(), "The list must be empty after all rows have been deleted from the database.");
    }

    @AfterAll
    public static void finish() throws SQLException {
        new EngineManufacturerDAO(useTestEnvironment).delete(safran);
        new ManufacturerDAO(useTestEnvironment).delete(dassault);
        new CategoryDAO(useTestEnvironment).delete(military);
        DatabaseConnection.getConnection().close();
    }
}
