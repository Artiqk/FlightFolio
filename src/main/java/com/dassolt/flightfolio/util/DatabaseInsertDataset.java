package com.dassolt.flightfolio.util;

import com.dassolt.flightfolio.model.Category;
import com.dassolt.flightfolio.model.EngineManufacturer;
import com.dassolt.flightfolio.model.Manufacturer;
import com.dassolt.flightfolio.model.Product;
import com.dassolt.flightfolio.service.CategoryService;
import com.dassolt.flightfolio.service.EngineManufacturerService;
import com.dassolt.flightfolio.service.ManufacturerService;
import com.dassolt.flightfolio.service.ProductService;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DatabaseInsertDataset {
    public static void main(String[] args) throws SQLException {
        CategoryService categoryService = new CategoryService();
        ManufacturerService manufacturerService = new ManufacturerService();
        EngineManufacturerService engineManufacturerService = new EngineManufacturerService();
        ProductService productService = new ProductService();

        Category commercial = new Category("Commercial");
        Category privateCat = new Category("Private");
        Category military = new Category("Military");
        categoryService.addCategory(commercial);
        categoryService.addCategory(privateCat);
        categoryService.addCategory(military);

        Manufacturer robin = new Manufacturer("Robin Aircraft");
        Manufacturer boeing = new Manufacturer("Boeing");
        Manufacturer dassault = new Manufacturer("Dassault");
        manufacturerService.addManufacturer(robin);
        manufacturerService.addManufacturer(boeing);
        manufacturerService.addManufacturer(dassault);

        EngineManufacturer honeywell = new EngineManufacturer("Honeywell Aerospace");
        EngineManufacturer ge = new EngineManufacturer("General Electric");
        EngineManufacturer safran = new EngineManufacturer("Safran Aircraft Engines");
        engineManufacturerService.addEngineManufacturer(honeywell);
        engineManufacturerService.addEngineManufacturer(ge);
        engineManufacturerService.addEngineManufacturer(safran);

        Product p1 = new Product("Robin DR-400", "A light, nimble, and economical single-engine plane, perfect for leisure flights and pilot training.", 120000.00, 10, 1, 4, 4000, false, robin.getId(), honeywell.getId(), privateCat.getId());
        Product p2 = new Product("Boeing 777X", "The newest member of the world-renowned Boeing 777 family, designed for efficiency and exceptional passenger comfort.", 320000000.00, 5, 2, 396, 13100, false, boeing.getId(), ge.getId(), commercial.getId());
        Product p3 = new Product("Rafale M", "A powerful and agile multirole fighter, equipped to operate from aircraft carriers and meet various mission requirements.", 78000000.00, 8, 2, 1, 15240, true, dassault.getId(), safran.getId(), military.getId());

        List<Product> productList = Arrays.asList(p1, p2, p3);

        for (Product product : productList) {
            productService.addProduct(product);
        }

        DatabaseConnection.getConnection().close();
    }
}
