DROP TABLE IF EXISTS master_duration;
DROP TABLE IF EXISTS service_schedule;
DROP TABLE IF EXISTS hair_service;
DROP TABLE IF EXISTS master;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS duration;
DROP TABLE IF EXISTS day_schedule;

CREATE TABLE client
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(30),
    surname   VARCHAR(30),
    phone     INT,
    email     VARCHAR(30),
    role      VARCHAR(30),
    login     VARCHAR(30),
    password  VARCHAR(30),
    hairstyle VARCHAR(30)
);

CREATE TABLE duration
(
    id        SERIAL PRIMARY KEY,
    day       VARCHAR(30),
    "fromTime" TIME,
    "toTime"   TIME
);

CREATE TABLE day_schedule
(
    id        SERIAL PRIMARY KEY,
    day       VARCHAR(30),
    "fromTime" TIME,
    "toTime"   TIME
);

CREATE TABLE master
(
    id       SERIAL PRIMARY KEY,
    photo    BYTEA,
    name     VARCHAR(30),
    surname  VARCHAR(30),
    phone    INT,
    email    VARCHAR(30),
    role     VARCHAR(30),
    login    VARCHAR(30),
    password VARCHAR(30)
);

CREATE TABLE hair_service
(
    id          SERIAL PRIMARY KEY,
    client_id   BIGINT NOT NULL,
    master_id   BIGINT NOT NULL,
    schedule_id BIGINT NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client (id),
    FOREIGN KEY (master_id) REFERENCES master (id),
    FOREIGN KEY (schedule_id) REFERENCES day_schedule (id)
);

CREATE TABLE service_schedule
(
    service_id  BIGINT,
    schedule_id BIGINT,
    FOREIGN KEY (service_id) REFERENCES hair_service (id),
    FOREIGN KEY (schedule_id) REFERENCES day_schedule (id),
    UNIQUE (service_id, schedule_id)
);

CREATE TABLE master_duration
(
    master_id   BIGINT,
    duration_id BIGINT,
    FOREIGN KEY (master_id) REFERENCES master (id),
    FOREIGN KEY (duration_id) REFERENCES duration (id),
    UNIQUE (master_id, duration_id)
);
