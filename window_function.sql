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
           over (partition by name, price ORDER BY name, price DESC range unbounded preceding) as sum_grade,
       avg(price) over (partition by name) as avg_grade,
       count(price) over (partition by name) as count_grade,
       min(price) over (partition by name) as min_grade,
       max(price) over (partition by name) as max_grade
from barter;

select name, price,
       row_number() over (partition by name order by price desc),
       rank() over (partition by name order by price desc),
       dense_rank() over (partition by name order by price desc)
from barter;
