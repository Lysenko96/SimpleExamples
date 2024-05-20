create table if not exists barter
(
    id    serial
        primary key,
    name  varchar(55),
    price integer
);

insert into barter(name, price) values ('name', 460), ('name1', 300), ('name', 320), ('name1', 770), ('name', 1200), ('name1', 975), ('name', 120);

select * from barter;

select name, price,
       sum(price)
       filter ( where price > 500)
           over (partition by name, price ORDER BY name, price DESC RANGE UNBOUNDED PRECEDING) as sum_price,
       avg(price) over (partition by name) as avg_price,
       count(price) over (partition by name) as count_price,
       min(price) over (partition by name) as min_price,
       max(price) over (partition by name) as max_price
from barter;

select name, price,
       row_number() over (partition by name order by price desc),
       rank() over (partition by name order by price desc),
       dense_rank() over (partition by name order by price desc)
from barter;


select name, price,
       lag(price) over (order by name) as previous_price,
       lead(price) over (order by name) as next_price
from barter;

select name, price,
       first_value(price) over (order by name ) as first_price,
       last_value(price) over (order by name RANGE BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) as last_price
from barter;
