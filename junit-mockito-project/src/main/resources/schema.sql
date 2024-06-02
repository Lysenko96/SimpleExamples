DROP TABLE IF EXISTS persons;

CREATE TABLE persons(
                        id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                        first_name VARCHAR(64) NOT NULL,
                        last_name VARCHAR(64) NOT NULL,
                        salary INT NOT NULL
);

INSERT INTO PERSONS(first_name, last_name, salary)
VALUES
    ('Jack','Richard',750),
    ('Tom','Hawk',1250),
    ('William','Cena',1000);