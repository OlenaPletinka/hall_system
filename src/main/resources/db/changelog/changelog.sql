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
CREATE TABLE event (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  time DATETIME NOT NULL,
  hall_id INT NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
  INDEX fk_event_hall_idx (hall_id ASC) VISIBLE,
  CONSTRAINT fk_event_hall
    FOREIGN KEY (hall_id)
    REFERENCES hall (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);

-- changeset liquibase:5
CREATE TABLE reservations (
  id INT NOT NULL AUTO_INCREMENT,
  seats_id INT NOT NULL,
  event_id INT NOT NULL,
  reserved_by VARCHAR(45) NULL,
  reservation_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
  INDEX fk_reservations_seats_idx (seats_id ASC) VISIBLE,
  INDEX fk_reservations_event_idx (event_id ASC) VISIBLE,
  CONSTRAINT fk_reservations_event
    FOREIGN KEY (event_id)
    REFERENCES event (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT fk_reservations_seats
    FOREIGN KEY (seats_id)
    REFERENCES seats (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);

-- changeset liquibase:6
INSERT INTO hall (id, name, seat_limit) VALUES (100, 'Central hall', 20), (101, 'Private hall', 2);

-- changeset liquibase:7
INSERT INTO seats (id, hall_id, seat_number) VALUES (1, 100, 1001), (2, 100, 1002), (3, 100, 1003), (4, 100, 1004),
(5, 100, 1005), (6, 100, 1006), (7, 100, 1007), (8, 100, 1008), (9, 100, 1009), (10, 100, 1010), (11, 100, 1011),
(12, 100, 1012), (13, 100, 1013), (14, 100, 1014), (15, 100, 1015), (16, 100, 1016), (17, 100, 1017), (18, 100, 1018),
(19, 100, 1019), (20, 100, 1020), (21, 101, 1011), (22, 101, 1012);

-- changeset liquibase:8
INSERT INTO event (id, name, time, hall_id) VALUES (1, 'Ballet', '2023-12-12 12:30:00.000000', 101),
(2, 'Opera', '2023-08-15 19:30:00.000000', 100), (3, 'Jasmin', '2023-10-12 17:30:00.000000', 100);


-- changeset liquibase:9
INSERT INTO reservations (id, seats_id, event_id, reserved_by) VALUES (1, 21, 1, 'Olena Pletinka'),
 (2, 22, 1, 'Olena Pletinka'), (3, 4, 2, 'Jon Kim');

