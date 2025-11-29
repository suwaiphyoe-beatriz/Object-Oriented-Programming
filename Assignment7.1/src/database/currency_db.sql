-- Drop previous database if it exists
DROP DATABASE IF EXISTS currency_converter;

-- Create the database
CREATE DATABASE currency_converter;
USE currency_converter;

-- Create the Currency table
CREATE TABLE Currency (
    id INT NOT NULL AUTO_INCREMENT,
    abbreviation VARCHAR(10) NOT NULL,
    name VARCHAR(50) NOT NULL,
    exchange_rate DECIMAL(15,6) NOT NULL,
    PRIMARY KEY (id)
);

-- Insert initial data
INSERT INTO Currency (abbreviation, name, exchange_rate) VALUES
    ('USD', 'US Dollar', 1.000000),
    ('EUR', 'Euro', 0.918000),
    ('GBP', 'British Pound', 0.792000),
    ('JPY', 'Japanese Yen', 144.000000),
    ('AUD', 'Australian Dollar', 1.545000),
    ('CAD', 'Canadian Dollar', 1.366000),
    ('CHF', 'Swiss Franc', 0.883000),
    ('CNY', 'Chinese Yuan', 7.185000);

-- Drop user if exists
DROP USER IF EXISTS 'appuser'@'localhost';

-- Create user
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';

-- Grant privileges
GRANT SELECT, INSERT, UPDATE, DELETE ON currency_converter.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;
