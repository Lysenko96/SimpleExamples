DROP TABLE IF EXISTS Car;

CREATE TABLE car
(
    id    SERIAL PRIMARY KEY,
    details_id BIGINT,
    name  VARCHAR(64),
    model VARCHAR(64),
    speed NUMERIC(10, 2)
);

DROP TABLE IF EXISTS car_details;

CREATE TABLE car_details
(
    id          SERIAL PRIMARY KEY,
    description VARCHAR(64)
);

INSERT INTO car_details (description) VALUES ('SCC Tautara');