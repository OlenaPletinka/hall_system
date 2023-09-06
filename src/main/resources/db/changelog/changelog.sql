-- liquibase formatted sql

-- changeset liquibase:1
CREATE DATABASE IF NOT EXISTS reservation_system;

-- changeset liquibase:2
CREATE TABLE hall (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  seat_limit INT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE);

-- changeset liquibase:3
CREATE TABLE seats (
  id INT NOT NULL AUTO_INCREMENT,
  hall_id INT NOT NULL,
  seat_number INT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
  INDEX fk_seat_hall_idx (hall_id ASC) VISIBLE,
  CONSTRAINT fk_seat_hall
    FOREIGN KEY (hall_id)
    REFERENCES hall (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);

-- changeset liquibase:4
CREATE TABLE reservations (
  id INT NOT NULL AUTO_INCREMENT,
  seats_id INT NOT NULL,
  reserved_by VARCHAR(45) NULL,
  reservation_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
  INDEX fk_reservations_seats_idx (seats_id ASC) VISIBLE,
  CONSTRAINT fk_reservations_seats
    FOREIGN KEY (seats_id)
    REFERENCES seats (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);

-- changeset liquibase:5
INSERT INTO hall (id, name, seat_limit) VALUES (100, 'Central hall', 4), (101, 'Private hall', 2);

-- changeset liquibase:6
INSERT INTO seats (id, hall_id, seat_number) VALUES (1, 100, 1001), (2, 100, 1002), (3, 100, 1003), (4, 100, 1004),
(5, 101, 1011), (6, 101, 1012);

