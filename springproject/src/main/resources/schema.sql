drop table if exists person;

create table person
(
    id       bigserial primary key,
    name     varchar(32),
    surname  varchar(32),
    year     integer,
    login    varchar(32),
    password varchar(128),
    email    varchar(32),
    phone    integer
);