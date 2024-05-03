package com.dassolt.flightfolio.util;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class ExportUtil {

    public static void exportToCSV() {
        try {
            // Connexion à la base de données
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String[] tables = {"category", "engine_manufacturer", "manufacturer", "product"};

            for (String table : tables) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM " + table);
                ResultSetMetaData metaData = resultSet.getMetaData();

                FileWriter writer = new FileWriter("backups/csv/" + table + ".csv");

                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    writer.append(metaData.getColumnName(i));
                    if (i < metaData.getColumnCount()) {
                        writer.append(",");
                    }
                }
                writer.append("\n");

                while (resultSet.next()) {
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        writer.append(resultSet.getString(i));
                        if (i < metaData.getColumnCount()) {
                            writer.append(",");
                        }
                    }
                    writer.append("\n");
                }

                writer.close();
                resultSet.close();
            }

            connection.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        exportToCSV();
    }
}
