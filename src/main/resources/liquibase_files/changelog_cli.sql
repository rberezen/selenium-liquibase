--liquibase formatted sql

--changeset qa:1
CREATE TABLE person (
                        id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                        last_name VARCHAR(50) NOT NULL,
                        first_name VARCHAR(50) NOT NULL
);

--changeset qa:2
INSERT INTO person (id, last_name, first_name) VALUES (1, 'Wee', 'Dee');

--changeset qa:3
INSERT INTO person (id, last_name, first_name) VALUES (2, 'Emm', 'Off');
