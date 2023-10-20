DROP TABLE IF EXISTS users;
CREATE TABLE users (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      username VARCHAR(50) NOT NULL,
                      password VARCHAR(50) NOT NULL,
                      role VARCHAR(50) NOT NULL
);