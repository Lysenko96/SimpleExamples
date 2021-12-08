
drop table if exists employee; 
drop table if exists department; 
drop table if exists company; 

create table employee(
id serial primary key,
name varchar(55),
surname varchar(55),
hours int,
begin int,
endwork int,
role varchar(55),
type varchar(55),
synch boolean,
performance numeric,
percent numeric,
salary numeric
);

create table department(
id serial primary key,
name varchar(55),
change boolean,
synch boolean,
idemployee int,
performance numeric,
FOREIGN KEY (idemployee) REFERENCES employee (id),
UNIQUE(name, idemployee, change, synch)
);

create table company(
id serial primary key,
name varchar(55),
street varchar(55),
number int,
countperson int,
iddepartment int,
FOREIGN KEY (iddepartment) REFERENCES department (id),
UNIQUE(name, iddepartment, street, number, countperson)
);