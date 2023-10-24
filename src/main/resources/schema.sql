DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS basic_data;
DROP TABLE IF EXISTS cards;
DROP TABLE IF EXISTS cdts;

CREATE TABLE users (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      username VARCHAR(50) NOT NULL,
                      password VARCHAR(50) NOT NULL,
                      role VARCHAR(50) NOT NULL
);

CREATE TABLE basic_data (
                       id INT AUTO_INCREMENT  PRIMARY KEY,
                       username_id INT NOT NULL,
                       full_name VARCHAR(50) NOT NULL,
                       identification_id VARCHAR(50) NOT NULL,
                       FOREIGN KEY (username_id) REFERENCES users (id)
);

CREATE TABLE cards (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          username_id INT NOT NULL,
                          product_name VARCHAR(50) NOT NULL,
                          card_number VARCHAR(50) NOT NULL,
                          expiration_date VARCHAR(50) NOT NULL,
                          ccv VARCHAR(50) NOT NULL,
                          FOREIGN KEY (username_id) REFERENCES users (id)
);

CREATE TABLE cdts (
                       id INT AUTO_INCREMENT  PRIMARY KEY,
                       username_id INT NOT NULL,
                       product_name VARCHAR(50) NOT NULL,
                       amount VARCHAR(50) NOT NULL,
                       init_date VARCHAR(50) NOT NULL,
                       end_date VARCHAR(50) NOT NULL,
                       rate VARCHAR(50) NOT NULL,
                       FOREIGN KEY (username_id) REFERENCES users (id)
);