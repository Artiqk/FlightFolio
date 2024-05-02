# Gestionnaire d'Inventaire de Produits

Ce projet consiste en un gestionnaire d'inventaire de produits développé en Java. Il utilise une base de données relationnelle pour stocker les informations sur les produits et offre une interface utilisateur via la console. L'application permet aux utilisateurs de gérer les produits en effectuant des opérations CRUD (Create, Read, Update, Delete), ainsi que d'exporter et d'importer les données d'inventaire depuis et vers des fichiers au format CSV ou JSON.

## Fonctionnalités

- Opérations CRUD sur les produits :
    - Ajout de nouveaux produits à l'inventaire.
    - Affichage de la liste des produits existants avec leurs détails.
    - Mise à jour des informations d'un produit existant.
    - Suppression d'un produit de l'inventaire.
- Exportation/Importation de Données :
    - Exportation des données d'inventaire vers un fichier local au format CSV ou JSON.
    - Importation des données d'inventaire à partir d'un fichier local au format CSV ou JSON, en ajoutant de nouveaux produits ou en mettant à jour les produits existants selon les données fournies.
- Interface Utilisateur Console :
    - Interface utilisateur claire et intuitive via la console, avec des menus et des options pour effectuer différentes opérations sur les produits.
    - Affichage de messages informatifs et d'instructions pour guider l'utilisateur tout au long de l'interaction avec l'application.
- Gestion des Erreurs :
    - Gestion des erreurs de connexion à la base de données, des erreurs d'entrée/sortie de fichiers, ainsi que des erreurs liées aux opérations sur les produits de manière appropriée.
    - Affichage de messages d'erreur détaillés pour informer l'utilisateur des problèmes rencontrés et des étapes à suivre pour les résoudre.

## Prérequis

- Java JDK installé sur votre système.
- Maven pour la gestion des dépendances et la construction du projet.
- Une base de données relationnelle compatible MySQL.

## Installation

1. Cloner ce dépôt sur votre machine locale :
   git clone git@github.com:FaraJoy/produits-java.git
2. Accéder au répertoire du projet : cd Produits-java
3. Compiler le projet à l'aide de Maven : mvn clean install

## Auteurs

- Antoine Abonneau
- Jacques Colin
- Fara Pailhès

## Licence

Ce projet est sous licence MIT - voir le fichier [LICENSE](LICENSE) pour plus de détails.