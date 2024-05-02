package org.connexion.db;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Charger les variables d'environnement à partir du fichier .env
        Dotenv dotenv = Dotenv.load();

        // Récupérer les informations de connexion à la base de données à partir des variables d'environnement
        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");

        try {
            // Établir une connexion à la base de données
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion à la base de données réussie !");

            // Utiliser la connexion...

            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }
}
