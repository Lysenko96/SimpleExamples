create database bookdb;

create role tohaa with superuser createdb createrole login encrypted password '1337';

grant all privileges on database bookdb to tohaa;

drop table if exists books;

create table books(
id serial primary key,
name varchar(55),
author varchar(55),
genre varchar(55),
pagecount int
);

select * from books;