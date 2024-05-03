package com.dassolt.flightfolio.util.dataloader;

import com.dassolt.flightfolio.model.Product;
import com.dassolt.flightfolio.service.ProductService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class ProductDataLoader {

    public static void main(String[] args) {
        // Chemin vers le fichier CSV
        String csvFile = "OUT/CSV/testProduct.csv";

        ProductService productService;
        try {
            productService = new ProductService();
            loadProductsFromCSV(csvFile, productService);
            System.out.println("Données insérées avec succès depuis le fichier CSV.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadProductsFromCSV(String csvFile, ProductService productService) throws IOException {
        String line;
        String csvSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Ignorer la première ligne car elle contient les en-têtes
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] data = line.split(csvSplitBy);

                Product product = new Product(
                        data[1], // name - String
                        data[2], // description - String
                        Double.parseDouble(data[3]), // price - double
                        Integer.parseInt(data[4]), // quantity - int
                        Integer.parseInt(data[5]), // engineNb - int
                        Integer.parseInt(data[6]), // seatNb - int
                        Double.parseDouble(data[7]), // wingspan - double
                        Double.parseDouble(data[8]), // length - double
                        Integer.parseInt(data[9]), // serviceCeiling - int
                        data[10].equals("0"), // canSpreadDemocracy - boolean
                        data[11], // manufacturerId - UUID
                        data[12], // engineManufacturerId - UUID
                        data[13] // categoryId - UUID
                );

                if (data[0].isEmpty()) {
                    productService.addProduct(product);
                } else {

                    product = new Product(
                            data[0], // id - UUID
                            data[1], // name - String
                            data[2], // description - String
                            Double.parseDouble(data[3]), // price - double
                            Integer.parseInt(data[4]), // quantity - int
                            Integer.parseInt(data[5]), // engineNb - int
                            Integer.parseInt(data[6]), // seatNb - int
                            Double.parseDouble(data[7]), // wingspan - double
                            Double.parseDouble(data[8]), // length - double
                            Integer.parseInt(data[9]), // serviceCeiling - int
                            data[10].equals("0"), // canSpreadDemocracy - boolean
                            data[11], // manufacturerId - UUID
                            data[12], // engineManufacturerId - UUID
                            data[13] // categoryId - UUID
                    );
                    productService.updateProduct(product);
                }
            }
        }
    }
}
