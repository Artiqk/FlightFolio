package com.dassolt.flightfolio.util;

import com.dassolt.flightfolio.model.Category;
import com.dassolt.flightfolio.model.EngineManufacturer;
import com.dassolt.flightfolio.model.Manufacturer;
import com.dassolt.flightfolio.model.Product;

import java.util.ArrayList;
import java.util.List;

public class DatabaseDataSetTest {
    public static void main(String[] args) {
        // Create Categories
        Category commercial = new Category("Commercial");
        Category privateCategory = new Category("Private");
        Category military = new Category("Military");

        // Create Manufacturers
        Manufacturer boeing = new Manufacturer("Boeing");
        Manufacturer airbus = new Manufacturer("Airbus");
        Manufacturer lockheedMartin = new Manufacturer("Lockheed Martin");
        Manufacturer dassault = new Manufacturer("Dassault");
        Manufacturer cessna = new Manufacturer("Cessna");

        // Create Engine Manufacturers
        EngineManufacturer ge = new EngineManufacturer("General Electric");
        EngineManufacturer rollsRoyce = new EngineManufacturer("Rolls-Royce");
        EngineManufacturer prattWhitney = new EngineManufacturer("Pratt & Whitney");
        EngineManufacturer safran = new EngineManufacturer("Safran Aircraft Engines");
        EngineManufacturer honeywell = new EngineManufacturer("Honeywell Aerospace");

        // Create Products
        Product robinDR400 = new Product("Robin DR-400", "A light, nimble, and economical single-engine plane, perfect for leisure flights and pilot training.", 120000.00, 10, 1, 4,  4000, false, cessna.getId(), honeywell.getId(), privateCategory.getId());
        Product cessna172 = new Product("Cessna 172", "The most popular flight training aircraft in the world, known for its reliability and ease of use.", 300000.00, 15, 1, 4, 14000, false, cessna.getId(), honeywell.getId(), privateCategory.getId());
        Product boeing777X = new Product("Boeing 777X", "The newest member of the world-renowned Boeing 777 family, designed for efficiency and exceptional passenger comfort.", 320000000.00, 5, 2, 396, 13100, false, boeing.getId(), ge.getId(), commercial.getId());
        Product boeing747 = new Product("Boeing 747 - The Queen of the Skies", "An iconic jumbo jet that revolutionized air travel with its size and range.", 387000000.00, 4, 4, 416, 13100, false, boeing.getId(), ge.getId(), commercial.getId());
        Product airbusA321Neo = new Product("Airbus A321 Neo", "A market-leading narrow-body jetliner that blends fuel efficiency with comfort and performance.", 129000000.00, 7, 2, 244, 12000, false, airbus.getId(), safran.getId(), commercial.getId());
        Product superHornet = new Product("F/A-18E Super Hornet", "A highly capable, twin-engine, multirole fighter known for its agility and stealth.", 70000000.00, 8, 2, 1, 15000, true, lockheedMartin.getId(), rollsRoyce.getId(), military.getId());
        Product f16Viper = new Product("F-16C Block 70 Viper", "A 4th generation multi-role fighter aircraft, known for its versatility and advanced avionics.", 64000000.00, 12, 1, 1, 15000, true, lockheedMartin.getId(), rollsRoyce.getId(), military.getId());
        Product rafaleM = new Product("Rafale M", "A powerful and agile multirole fighter, equipped to operate from aircraft carriers and meet various mission requirements.", 74000000.00, 9, 1, 1, 15235, true, dassault.getId(), safran.getId(), military.getId());

        // List for demonstration purposes
        List<Product> products = new ArrayList<>();
        products.add(robinDR400);
        products.add(cessna172);
        products.add(boeing777X);
        products.add(boeing747);
        products.add(airbusA321Neo);
        products.add(superHornet);
        products.add(f16Viper);
        products.add(rafaleM);

        // Printing details of each product to verify
        products.forEach(System.out::println);
    }
}
