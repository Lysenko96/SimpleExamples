DROP TABLE IF EXISTS contacts;
CREATE TABLE contacts
(
    id     serial PRIMARY KEY,
    name   VARCHAR(100),
    phones TEXT[],
    file   bytea
);