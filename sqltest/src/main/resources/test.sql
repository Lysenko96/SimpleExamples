select * from singer,singer_instrument where singer.id = singer_instrument.singer_id;
select album.singer_id from album  join singer_instrument on album.singer_id= singer_instrument.singer_id ;--where singer_id=2;
select instrument_id from singer_instrument  natural join album ;--where singer_id=2;
select * from singer left outer join singer_instrument si on singer.id = si.singer_id;
select * from singer left join singer_instrument si on singer.id = si.singer_id;
select * from singer left join singer_instrument si on singer.id = si.singer_id where si.singer_id is null;
select * from album right join singer s on album.singer_id = s.id;
select * from album right join singer s on album.singer_id = s.id where album.singer_id is null;
select * from album full outer join singer s on album.singer_id = s.id;
select * from album full join singer s on album.singer_id = s.id;
select * from instrument i cross join singer_instrument si;
-- upper, lower, substring, reverse, ltrim, rtrim, left, right
select left(title, 2) as title_little from album;
select max(release_date), singer_id from album group by singer_id;
select max(release_date), singer_id from album group by singer_id having count(release_date) > 1;
alter table album add column track_counter int ;--default 0;
alter table album drop column track_counter;
alter table album drop column instrument_id;
alter table album add column description varchar(20);


start transaction;
update album set track_counter =
                     case
                         -- when title  = 'Music'
                         -- then 'Music123'
                         when track_counter is null
                             then 1
                         end;
update album set version =
                     case
                         -- when title  = 'Music'
                         -- then 'Music123'
                         when track_counter = 1
                             then 6
                         end;
commit;

alter table album rename column track_counter to counter_track;
select * from album where counter_track in (select counter from track);

select * from album where exists (select null); -- return true if null

select * from singer where exists(select counter from track);
select singer_id from singer_instrument;
select * from singer;
select * from singer where not exists (select singer_id from singer_instrument);
select * from singer where birth_date = any (select release_date from album);
select * from singer where birth_date > some (select release_date from album);
select * from singer where birth_date < all (select release_date from album);
select * from album where release_date > all (select birth_date from singer);

select  singer_id, sum(counter_track) from album group by singer_id order by sum(counter_track);



alter table album add column track_id int;
alter table album add column track_id int;

alter table album add constraint fk_track_id foreign key (track_id) references track(id);
alter table album drop constraint fk_track_id;
alter table album add column instrument_id varchar(20);
--alter table album drop column instrument_id ;
alter table album add constraint fk_instrument_id foreign key (instrument_id) references instrument(instrument_id);
--alter table album drop constraint fk_instrument_id;
select id, counter_track, coalesce(counter_track, 5) from album;
alter table album rename column counter_track to track_counter;

do $$
begin
if (select track_counter from album where track_counter is null limit 1) is null then
update album set track_counter = 3 where album.track_counter is null;
end if;
end $$;
-- Common Table Expression
with table_cte (title, year_begin) as (select title, extract(day from release_date) as year_begin from album)
select title, year_begin from table_cte ;--where year_begin > 2000;

select singer_id from album union select id from singer;
select singer_id from album union all select id from singer;

select singer_id from album intersect select id from singer;
select singer_id from album except select id from singer;

create view my_view as select * from album where title ilike '%From%' with check option;

insert into my_view (singer_id, title, release_date)
values (1, 'from', '2017-01-20');

start transaction;
update album set version = 1 where  version = 55;
select * from album;
rollback;
select * from album;


start transaction;
update album set version = 11 where  version = 55;
select * from album;
commit;
select * from album;
