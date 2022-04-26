select distinct author_id as id
from views
where author_id = viewer_id order by id;

select name
from customer
where referee_id != 2 or referee_id is null;