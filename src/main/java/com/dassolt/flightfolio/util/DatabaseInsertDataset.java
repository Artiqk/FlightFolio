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
        CategoryService categoryService = new CategoryService(true);
        ManufacturerService manufacturerService = new ManufacturerService(true);
        EngineManufacturerService engineManufacturerService = new EngineManufacturerService(true);
        ProductService productService = new ProductService(true);

        Category commercial = new Category("Commercial");
        Category privateCat = new Category("Private");
        Category military = new Category("Military");
        categoryService.addCategory(commercial);
        categoryService.addCategory(privateCat);
        categoryService.addCategory(military);

        Manufacturer boeing = new Manufacturer("Boeing");
        Manufacturer airbus = new Manufacturer("Airbus");
        Manufacturer lockheed = new Manufacturer("Lockheed Martin");
        Manufacturer dassault = new Manufacturer("Dassault");
        Manufacturer cessna = new Manufacturer("Cessna");
        manufacturerService.addManufacturer(boeing);
        manufacturerService.addManufacturer(airbus);
        manufacturerService.addManufacturer(lockheed);
        manufacturerService.addManufacturer(dassault);
        manufacturerService.addManufacturer(cessna);

        EngineManufacturer ge = new EngineManufacturer("General Electric");
        EngineManufacturer rollsRoyce = new EngineManufacturer("Rolls-Royce");
        EngineManufacturer pratt = new EngineManufacturer("Pratt & Whitney");
        EngineManufacturer safran = new EngineManufacturer("Safran Aircraft Engines");
        EngineManufacturer honeywell = new EngineManufacturer("Honeywell Aerospace");
        engineManufacturerService.addEngineManufacturer(ge);
        engineManufacturerService.addEngineManufacturer(rollsRoyce);
        engineManufacturerService.addEngineManufacturer(pratt);
        engineManufacturerService.addEngineManufacturer(safran);
        engineManufacturerService.addEngineManufacturer(honeywell);

        Product p1 = new Product("Robin DR-400", "A light, nimble, and economical single-engine plane, perfect for leisure flights and pilot training.", 120000.00, 10, 1, 4, 4000, false, cessna.getId(), honeywell.getId(), privateCat.getId());
        Product p2 = new Product("Boeing 777X", "The newest member of the world-renowned Boeing 777 family, designed for efficiency and exceptional passenger comfort.", 320000000.00, 5, 2, 396, 13100, false, boeing.getId(), ge.getId(), commercial.getId());
        Product p3 = new Product("Rafale M", "A powerful and agile multirole fighter, equipped to operate from aircraft carriers and meet various mission requirements.", 78000000.00, 8, 2, 1, 15240, true, dassault.getId(), safran.getId(), military.getId());

        List<Product> productList = Arrays.asList(p1, p2, p3);

        for (Product product : productList) {
            productService.addProduct(product);
        }

        DatabaseConnection.getConnection().close();
    }
}
