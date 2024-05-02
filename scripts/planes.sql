DROP DATABASE IF EXISTS planes;

-- Create database if it does not already exist
CREATE DATABASE IF NOT EXISTS planes;
USE planes;

-- Create the Category table
CREATE TABLE `category` (
  `id` int AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(255) UNIQUE NOT NULL
);

-- Create the Manufacturer table
CREATE TABLE `manufacturer` (
  `id` int AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(255) UNIQUE NOT NULL
);

-- Create the Engine Manufacturer table
CREATE TABLE `engine_manufacturer` (
  `id` int AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(255) UNIQUE NOT NULL
);

-- Create the Product table
CREATE TABLE `product` (
  `id` int AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(255) UNIQUE NOT NULL,
  `description` TEXT,
  `price` DECIMAL(11,2) NOT NULL,
  `quantity` int DEFAULT 0,
  `manufacturer_id` int NOT NULL,
  `engine_nb` int NOT NULL,
  `engine_manufacturer_id` int NOT NULL,
  `seat_nb` int NOT NULL,
  `wingspan` DECIMAL(10,2) NOT NULL,
  `length` DECIMAL(10,2) NOT NULL,
  `service_ceiling` int NOT NULL,
  `can_spread_democracy` TINYINT(1) NOT NULL DEFAULT 0,
  `category_id` int,
  FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE SET NULL,
  FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`id`),
  FOREIGN KEY (`engine_manufacturer_id`) REFERENCES `engine_manufacturer` (`id`)
);

-- Insert categories (sample data)
INSERT INTO `category` (name) VALUES
('Commercial'),
('Private'),
('Military');

-- Insert manufacturers (sample data)
INSERT INTO `manufacturer` (name) VALUES
('Boeing'),
('Airbus'),
('Lockheed Martin'),
('Dassault'),
('Cessna');

-- Insert engine manufacturers (sample data)
INSERT INTO `engine_manufacturer` (name) VALUES
('General Electric'),
('Rolls-Royce'),
('Pratt & Whitney'),
('Safran Aircraft Engines'),
('Honeywell Aerospace');

-- Insert products (sample data for planes with descriptions)
INSERT INTO `product` (
  name, description, price, quantity, manufacturer_id, engine_nb, engine_manufacturer_id,
  seat_nb, wingspan, length, service_ceiling, can_spread_democracy, category_id
) VALUES
('Robin DR-400', 'A light, nimble, and economical single-engine plane, perfect for leisure flights and pilot training.', 120000.00, 10, 5, 1, 5, 4, 8.72, 6.96, 4000, 0, 2),
('Cessna 172', 'The most popular flight training aircraft in the world, known for its reliability and ease of use.', 300000.00, 15, 5, 1, 5, 4, 11.00, 8.28, 14000, 0, 2),
('Boeing 777X', 'The newest member of the world-renowned Boeing 777 family, designed for efficiency and exceptional passenger comfort.', 320000000.00, 5, 1, 2, 1, 396, 64.80, 73.90, 13100, 0, 1),
('Boeing 747 - The Queen of the Skies', 'An iconic jumbo jet that revolutionized air travel with its size and range.', 387000000.00, 4, 1, 4, 1, 416, 68.40, 70.60, 13100, 0, 1),
('Airbus A321 Neo', 'A market-leading narrow-body jetliner that blends fuel efficiency with comfort and performance.', 129000000.00, 7, 2, 2, 4, 244, 35.80, 44.50, 12000, 0, 1),
('F/A-18E Super Hornet', 'A highly capable, twin-engine, multirole fighter known for its agility and stealth.', 70000000.00, 8, 3, 2, 3, 1, 13.62, 18.31, 15000, 1, 1),
('F-16C Block 70 Viper', 'A 4th generation multi-role fighter aircraft, known for its versatility and advanced avionics.', 64000000.00, 12, 3, 1, 3, 1, 9.96, 15.06, 15000, 1, 3),
('Rafale M', 'A powerful and agile multirole fighter, equipped to operate from aircraft carriers and meet various mission requirements.', 74000000.00, 9, 4, 1, 4, 1, 10.90, 15.27, 15235, 1, 3);
