drop table if exists coolers;
drop table if exists recipies;
drop table if exists products;

create table products(
id bigint auto_increment PRIMARY KEY,
name varchar(55),
count int,
type varchar(55),
price numeric(10,2)
);

create table coolers(
id bigint auto_increment PRIMARY KEY,
model varchar(55),
productid int,
foreign key (productid) references products (id)
);

create table recipies(
id bigint auto_increment PRIMARY KEY,
name varchar(55),
productid int,
foreign key (productid) references products (id)
);
