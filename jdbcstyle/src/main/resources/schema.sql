drop table if exists person;

create table person
(
    id         serial primary key,
    name       text,
    surname    text,
    sex        text,
    email      text,
    year       int,
    address    text,
    phone      int,
    "postCode" text
);

drop table if exists person_test;

create table person_test
(
    id         serial primary key,
    name       text,
    surname    text,
    sex        text,
    email      text,
    year       int,
    address    text,
    phone      int,
    "postCode" text
);