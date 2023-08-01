select * from singer inner join singer_instrument si on singer.id = si.singer_id;
select * from singer left outer join singer_instrument si on singer.id = si.singer_id;
select * from singer left join singer_instrument si on singer.id = si.singer_id;
select * from singer left join singer_instrument si on singer.id = si.singer_id where si.singer_id is null;
select * from album right join singer s on album.singer_id = s.id;
select * from album right join singer s on album.singer_id = s.id where album.singer_id is null;
select * from album full outer join singer s on album.singer_id = s.id;
select * from album full join singer s on album.singer_id = s.id;
select * from instrument i cross join singer_instrument si;
select max(release_date), singer_id from album group by singer_id;
select max(release_date), singer_id from album group by singer_id having count(release_date) > 1;
alter table album add column track_counter int ;--default 0;
alter table album drop column track_counter;
alter table album add column track_id int;
alter table album add constraint fk_track_id foreign key (track_id) references track(id);
alter table album drop constraint fk_track_id;
select id, track_counter, coalesce(track_counter, 5) from album;

do $$
begin
if (select track_counter from album where track_counter is null limit 1) is null then
update album set track_counter = 3 where album.track_counter is null;
end if;
end $$;
-- Common Table Expression
with table_cte (title, year_begin) as (select title, extract(year from release_date) as year_begin from album)
select title, year_begin from table_cte ;--where year_begin > 2000;