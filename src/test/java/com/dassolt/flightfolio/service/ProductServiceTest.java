package com.dassolt.flightfolio.service;

import com.dassolt.flightfolio.model.Category;
import com.dassolt.flightfolio.model.EngineManufacturer;
import com.dassolt.flightfolio.model.Manufacturer;
import com.dassolt.flightfolio.model.Product;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductServiceTest {
    private static ProductService service;

    private static Category military;
    private static Manufacturer dassault;
    private static EngineManufacturer safran;
    private static Product rafaleM;

    private static final boolean useTestEnvironment = true;

    @BeforeAll
    public static void setup() throws SQLException {
        service = new ProductService(useTestEnvironment); // Using test environment

        military = new Category("Military");
        dassault = new Manufacturer("Dassault");
        safran = new EngineManufacturer("Safran");
        rafaleM = new Product("Rafale M", "A powerful and agile multirole fighter, equipped to operate from aircraft carriers and meet various mission requirements.", 74000000.00, 9, 2, 1, 15235, true, dassault.getId(), safran.getId(), military.getId());

        // Add necessary linked entities first
        // Assume these services exist and are setup for test environments as well
        new CategoryService(useTestEnvironment).addCategory(military);
        new ManufacturerService(useTestEnvironment).addManufacturer(dassault);
        new EngineManufacturerService(useTestEnvironment).addEngineManufacturer(safran);
    }

    @Test
    @Order(1)
    public void createTest() {
        service.addProduct(rafaleM);
        assertNotNull(service.retrieveProductById(rafaleM.getId()), "The object must be found in the database.");
    }

    @Test
    @Order(2)
    public void retrieveAllProductsTest() {
        assertEquals(1, service.retrieveAllProducts().size(), "The size of the list should be equal to 1.");
    }

    @Test
    @Order(3)
    public void retrieveProductByIdTest() {
        Product foundProduct = service.retrieveProductById(rafaleM.getId());
        assertEquals(rafaleM, foundProduct, "The 2 objects must be identical.");
    }

    @Test
    @Order(4)
    public void updateProductTest() {
        final String newName = "Rafale Mc Queen";
        final boolean newDemocracy = false;

        rafaleM.setName(newName);
        rafaleM.setCanSpreadDemocracy(newDemocracy);
        service.updateProduct(rafaleM);

        Product updatedProduct = service.retrieveProductById(rafaleM.getId());
        assertEquals(newName, updatedProduct.getName(), "The name in the database must be equal to the new name.");
        assertFalse(updatedProduct.canSpreadDemocracy(), "The jet fighter must not be able to spread democracy.");
    }

    @Test
    @Order(5)
    public void deleteProductTest() {
        service.deleteProduct(rafaleM);
        assertTrue(service.retrieveAllProducts().isEmpty(), "The list must be empty after all rows have been deleted from the database.");
    }

    @AfterAll
    public static void finish() throws SQLException {
        new EngineManufacturerService(useTestEnvironment).deleteEngineManufacturer(safran);
        new ManufacturerService(useTestEnvironment).deleteManufacturer(dassault);
        new CategoryService(useTestEnvironment).deleteCategory(military);
    }
}
