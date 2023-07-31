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

