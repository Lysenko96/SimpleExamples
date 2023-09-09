-- need set id when insert else error
-- id add to database from values
-- database don't created default id
insert into car_auto (id,model) values (2,'lexus');
-- don't need set id
-- database generated id automatically
-- database created default id
insert into car_identity (model) values ('bmw');
-- need set id when insert else error
-- id add to database from values
-- database don't created default id
insert into car_sequence (id, model) values (4,'nissan');
-- need set id when insert else error
-- id add to database from values
-- database don't created default id
-- create hibernate_sequences table
insert into car_table (id, model) values (33,'benz');
---------------------------------------

insert into category (name) values ('A1');
-- @Transient Address don't see in table
insert into driver (name) values ('Kolya');

insert into driver_categories (category_id, driver_id) values (1,1);