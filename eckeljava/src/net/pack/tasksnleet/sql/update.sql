create table Products
(
    product_id int,
    store1     int,
    store2     int,
    store3     int
);

insert into products (product_id, store1, store2, store3)
VALUES (0, 95, 100, 105);
insert into products (product_id, store1, store2, store3)
VALUES (1, 70, null, 80);


select product_id, 'store1' as store, store1 as price
from products
where store1 is not null
union
select product_id, 'store2' as store, store2 as store
from products
where store2 is not null
union
select product_id, 'store3' as store, store3 as store
from products
where store3 is not null;

create table Activities
(
    sell_date date,
    product   varchar
);

insert into Activities (sell_date, product)
VALUES ('2020-05-30', 'Headphone');
insert into Activities (sell_date, product)
VALUES ('2020-06-01', 'Pencil');
insert into Activities (sell_date, product)
VALUES ('2020-06-02', 'Mask');
insert into Activities (sell_date, product)
VALUES ('2020-05-30', 'Basketball');
insert into Activities (sell_date, product)
VALUES ('2020-06-01', 'Bible');
insert into Activities (sell_date, product)
VALUES ('2020-06-02', 'Mask');
insert into Activities (sell_date, product)
VALUES ('2020-05-30', 'T-Shirt');

select sell_date, sum(mycount)
from (select sell_date, count(product) as mycount from activities group by sell_date) as foo
group by sell_date;
select sell_date, sum(mycount)
from (select sell_date, count(product) as mycount, product
      from activities
      where sell_date = '2020-05-30'
      group by product, sell_date) as foo
group by sell_date;

select sell_date,
       count(mycount) as num_sold,
       'Basketball,'
           'Headphone,'
           'T-Shirt'
                      as products
from (select distinct sell_date, product as mycount, product as products
      from activities
      where sell_date = '2020-05-30'
      group by sell_date, product) as foo
group by sell_date
union
select sell_date,
       count(mycount) as num_sold,
       'Mask'
                      as products
from (select distinct sell_date, product as mycount, product as products
      from activities
      where sell_date = '2020-06-02'
      group by sell_date, product) as foo
group by sell_date
union
select sell_date,
       count(mycount) as num_sold,
       'Bible,'
           'Pencil'
                      as products
from (select distinct sell_date, product as mycount, product as products
      from activities
      where sell_date = '2020-06-01'
      group by sell_date, product) as foo
group by sell_date order by num_sold desc;


create table human(
    sex varchar
);

insert into human (sex) values ('m');
insert into human (sex) values ('f');


update human set sex = case sex
                           when 'm' then 'f'
                           when 'f' then 'm'
                           else sex end;

select 'm' as sex from human where sex='f' union
select 'f' as sex from human where sex='m';


update human set sex = '1' where sex = 'm';
update human set sex = 'f' where sex = 'm';
update human set sex = 'm' where sex = '1';