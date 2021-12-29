drop table if exists person;

create table person(
id serial primary key,
name text,
surname text,
sex text,
email text,
year int,
address text,
phone int,
"postCode" text
);