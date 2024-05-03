package com.dassolt.flightfolio.util.dataloader;

import com.dassolt.flightfolio.model.EngineManufacturer;
import com.dassolt.flightfolio.service.EngineManufacturerService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class EngineManufacturerDataLoader {

    public static void main(String[] args) {
        // Chemin vers le fichier CSV
        String csvFile = "OUT/CSV/testEngineManufacturer.csv";

        EngineManufacturerService engineManufacturerService;
        try {
            engineManufacturerService = new EngineManufacturerService();
            loadEngineManufacturerFromCSV(csvFile, engineManufacturerService);
            System.out.println("Données insérées avec succès depuis le fichier CSV.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadEngineManufacturerFromCSV(String csvFile, EngineManufacturerService engineManufacturerService) throws IOException {
        String line;
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Ignorer la première ligne car elle contient les en-têtes
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] data = line.split(csvSplitBy);

                EngineManufacturer engineManufacturer = new EngineManufacturer(data[1]);

                if (data[0].isEmpty()) {
                    engineManufacturerService.addEngineManufacturer(engineManufacturer);
                } else {
                    engineManufacturer = new EngineManufacturer(data[0], data[1]);
                    engineManufacturerService.updateEngineManufacturer(engineManufacturer);
                }
            }
        }
    }
}
