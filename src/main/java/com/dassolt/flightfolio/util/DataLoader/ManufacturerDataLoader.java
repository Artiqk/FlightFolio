package com.dassolt.flightfolio.util.DataLoader;

import com.dassolt.flightfolio.model.Manufacturer;
import com.dassolt.flightfolio.service.ManufacturerService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class ManufacturerDataLoader {

    public static void main(String[] args) {
        // Chemin vers le fichier CSV
        String csvFile = "OUT/CSV/testManufacturer.csv";

        ManufacturerService manufacturerService;
        try {
            manufacturerService = new ManufacturerService();
            loadManufacturerFromCSV(csvFile, manufacturerService);
            System.out.println("Données insérées avec succès depuis le fichier CSV.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadManufacturerFromCSV(String csvFile, ManufacturerService manufacturerService) throws IOException {
        String line;
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Ignorer la première ligne car elle contient les en-têtes
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] data = line.split(csvSplitBy);

                Manufacturer manufacturer = new Manufacturer(data[1]);

                if (data[0].isEmpty()) {
                    manufacturerService.addManufacturer(manufacturer);
                } else {
                    manufacturer = new Manufacturer(data[0], data[1]);
                    manufacturerService.updateManufacturer(manufacturer);
                }
            }
        }
    }
}
