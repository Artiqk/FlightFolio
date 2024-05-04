DROP DATABASE IF EXISTS planes;

-- Create database if it does not already exist
CREATE DATABASE IF NOT EXISTS planes;
USE planes;

-- Create the Category table
CREATE TABLE `category` (
  `id` varchar(36) PRIMARY KEY,
  `name` varchar(255) UNIQUE NOT NULL
);

-- Create the Manufacturer table
CREATE TABLE `manufacturer` (
  `id` varchar(36) PRIMARY KEY,
  `name` varchar(255) UNIQUE NOT NULL
);

-- Create the Engine Manufacturer table
CREATE TABLE `engine_manufacturer` (
  `id` varchar(36) PRIMARY KEY,
  `name` varchar(255) UNIQUE NOT NULL
);

-- Create the Product table
CREATE TABLE `product` (
  `id` varchar(36) PRIMARY KEY,
  `name` varchar(255) UNIQUE NOT NULL,
  `description` TEXT,
  `price` DECIMAL(11,2) NOT NULL,
  `quantity` int DEFAULT 0,
  `manufacturer_id` varchar(36) NOT NULL,
  `engine_nb` int NOT NULL,
  `engine_manufacturer_id` varchar(36) NOT NULL,
  `seat_nb` int NOT NULL,
  `service_ceiling` int NOT NULL,
  `can_spread_democracy` TINYINT(1) NOT NULL DEFAULT 0,
  `category_id` varchar(36),
  FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE SET NULL,
  FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`id`),
  FOREIGN KEY (`engine_manufacturer_id`) REFERENCES `engine_manufacturer` (`id`)
);