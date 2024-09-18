CREATE TABLE account
(
    id      INT         NOT NULL AUTO_INCREMENT,
    name    VARCHAR(50) NOT NULL,
    balance DOUBLE      NOT NULL
);

INSERT INTO account (name, balance) VALUES ('John Mohawk', 1000);
INSERT INTO account (name, balance) VALUES ('Tony Stark', 1000);