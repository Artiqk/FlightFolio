package com.dassolt.flightfolio.util;

import com.dassolt.flightfolio.model.Category;
import com.dassolt.flightfolio.service.CategoryService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class CategoryDataLoader {

    public static void main(String[] args) {
        // Chemin vers le fichier CSV
        String csvFile = "OUT/CSV/testCategory.csv";

        CategoryService categoryService;
        try {
            categoryService = new CategoryService();
            loadCategoriesFromCSV(csvFile, categoryService);
            System.out.println("Données insérées avec succès depuis le fichier CSV.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadCategoriesFromCSV(String csvFile, CategoryService categoryService) throws IOException {
        String line;
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Ignorer la première ligne car elle contient les en-têtes
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] data = line.split(csvSplitBy);

                Category category = new Category(data[1]);

                if (data[0].isEmpty()) {
                    categoryService.addCategory(category);
                } else {
                    category = new Category(data[0], data[1]);
                    categoryService.updateCategory(category);
                }
            }
        }
    }
}
