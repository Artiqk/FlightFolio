package com.dassolt.flightfolio.util;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;
    static {
        // Charger les variables d'environnement à partir du fichier .env
        Dotenv dotenv = Dotenv.load();

        // Récupérer les informations de connexion à la base de données à partir des variables d'environnement
        URL = dotenv.get("DB_URL");
        USER = dotenv.get("DB_USER");
        PASSWORD = dotenv.get("DB_PASSWORD");
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
