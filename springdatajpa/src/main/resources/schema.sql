DROP TABLE IF EXISTS Car;

CREATE TABLE car
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(64),
    model VARCHAR(64),
    speed NUMERIC(10, 2)
);

DROP TABLE IF EXISTS car_details;

CREATE TABLE car_details
(
    id          SERIAL PRIMARY KEY,
    car_id      BIGINT,
    description VARCHAR(64)
);

INSERT INTO car_details (car_id, description) VALUES (1, 'SCC Tautara');