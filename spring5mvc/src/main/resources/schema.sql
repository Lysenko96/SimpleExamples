DROP TABLE IF EXISTS singer;


CREATE TABLE singer
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(60) NOT NULL,
    last_name  VARCHAR(40) NOT NULL,
    birth_date DATE,
    description VARCHAR(2000),
    photo BYTEA,
    version    INT         NOT NULL DEFAULT 0,
    UNIQUE (first_name, last_name)
);