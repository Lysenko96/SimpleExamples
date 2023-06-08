DROP TABLE IF EXISTS person;
create table person(
    id SERIAL PRIMARY KEY,
    firstname VARCHAR(32),
    lastname VARCHAR(32),
    year INT,
    address VARCHAR(64),
    email VARCHAR(32),
    phone INT,
    sex VARCHAR(32),
    role varchar(32)
)