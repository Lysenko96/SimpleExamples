drop table if exists person;

create table person(
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
)