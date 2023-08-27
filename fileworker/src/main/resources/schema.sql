DROP TABLE IF EXISTS entity;
CREATE TABLE entity
(
    id     serial PRIMARY KEY,
    name   VARCHAR(100),
    phones TEXT[],
    file   bytea,
    blob   bigint
);