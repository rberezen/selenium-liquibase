--liquibase formatted sql

--changeset qa:1
CREATE TABLE person (
                        id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                        last_name VARCHAR(50) NOT NULL,
                        first_name VARCHAR(50) NOT NULL
);

--changeset qa:2
INSERT INTO person (id, last_name, first_name) VALUES (1, 'Ola', 'Goo');

--changeset qa:3
INSERT INTO person (id, last_name, first_name) VALUES (2, 'Foo', 'Bar');

--changeset qa:4
INSERT INTO person (id, last_name, first_name) VALUES (3, 'Ola', 'Goo');

--changeset qa:5
INSERT INTO person (id, last_name, first_name) VALUES (4, 'Foo', 'Bar');

--changeset qa:6
INSERT INTO person (id, last_name, first_name) VALUES (5, 'Ola', 'Goo');

--changeset qa:7
INSERT INTO person (id, last_name, first_name) VALUES (6, 'Foo', 'Bar');
