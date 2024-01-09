CREATE TABLE note
(
    id         SERIAL PRIMARY KEY,
    title VARCHAR(64) NOT NULL,
    body  VARCHAR(64),
    person_id BIGINT REFERENCES person (id)
);