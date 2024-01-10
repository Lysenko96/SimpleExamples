SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;


SELECT * FROM product WHERE id=4;
UPDATE product SET price = 55.2 WHERE id=4;

BEGIN TRANSACTION;

INSERT INTO product(name, price) VALUES ('Book2',22.3);
INSERT INTO product(name, price) VALUES ('Clean Code',44.5);
INSERT INTO product(name, price) VALUES ('Core Java',46.8);

COMMIT;

ROLLBACK;



INSERT INTO product(name, price) VALUES ('Spring in Action',87.4);
