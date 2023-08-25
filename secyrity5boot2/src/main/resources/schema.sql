DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    username VARCHAR(32) PRIMARY KEY,
    password VARCHAR(65) not null,
    enabled   BOOLEAN
);

CREATE TABLE authorities
(
    username  VARCHAR(32) not null,
    authority VARCHAR(60) not null ,
    FOREIGN KEY (username) REFERENCES users (username),
    UNIQUE (username, authority)
);

