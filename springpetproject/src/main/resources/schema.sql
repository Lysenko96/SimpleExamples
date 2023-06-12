DROP TABLE IF EXISTS person;

CREATE TABLE person(
    id SERIAL PRIMARY KEY,
    firstname VARCHAR(32),
    lastname VARCHAR(32),
    login VARCHAR(32),
    password VARCHAR(32),
    year INT,
    email VARCHAR(32),
    address VARCHAR(32),
    phone VARCHAR(32),
    role VARCHAR(32)
);

DROP TABLE IF EXISTS task;

CREATE TABLE task(
  id SERIAL PRIMARY KEY,
  person_id BIGINT,
  name VARCHAR(64),
  description VARCHAR(256),
  status VARCHAR(32)
);