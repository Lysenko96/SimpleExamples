select * from cinema where id % 2 != 0 and description != 'boring' order by rating desc;

create table actordirector(
 actor_id int,
 director_id int,
 timestamp int
);

insert into actordirector values (1,1,0);
insert into actordirector values (1,1,1);
insert into actordirector values (1,1,2);
insert into actordirector values (1,2,3);
insert into actordirector values (1,2,4);
insert into actordirector values (2,1,5);
insert into actordirector values (2,1,6);

select actor_id, director_id from
                                 (select actor_id, director_id, count(actor_id) as count
                                  from actordirector
                                  group by actor_id, director_id) as c
                             where c.count >= 3;