package com.dassolt.flightfolio.util;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;
    private static final String URL_TEST;
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;
    static {
        // Charger les variables d'environnement à partir du fichier .env
        Dotenv dotenv = Dotenv.load();

        // Récupérer les informations de connexion à la base de données à partir des variables d'environnement
        URL_TEST = dotenv.get("DB_URL_TEST");
        URL = dotenv.get("DB_URL");
        USER = dotenv.get("DB_USER");
        PASSWORD = dotenv.get("DB_PASSWORD");
    }

    public static Connection getConnection(boolean isTestEnvironment) throws SQLException {
        final String url = isTestEnvironment ? URL_TEST : URL;

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, USER, PASSWORD);
        }
        return connection;
    }

    public static Connection getConnection() throws SQLException {
        return getConnection(false);
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
