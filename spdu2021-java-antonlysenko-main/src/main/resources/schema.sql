drop table if exists coolers;
drop table if exists recipies;
drop table if exists products;

create table products(
id serial primary key,
name varchar(55),
count int,
type varchar(55),
price numeric(10,2)
);

create table coolers(
id serial primary key,
model varchar(55),
productid int,
foreign key (productid) references products (id)
);

create table recipies(
id serial primary key,
name varchar(55),
productid int,
foreign key (productid) references products (id)
);
