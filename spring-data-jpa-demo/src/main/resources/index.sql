CREATE INDEX note_person_id_idx ON note(person_id); -- if many entries in table find faster by index then by field
DROP INDEX note_person_id_idx;

EXPLAIN ANALYZE SELECT * FROM person p JOIN note n ON p.id = n.person_id;

--https://explain.depesz.com/