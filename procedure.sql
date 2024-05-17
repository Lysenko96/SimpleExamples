DROP PROCEDURE transfer(sourceAccountId bigInt, destinationAccountId bigInt, amount Integer);

CREATE OR REPLACE PROCEDURE transfer(sourceAccountId bigInt, destinationAccountId bigInt, amount Integer)
    language plpgsql
as $$
begin
    update barter
    set price = barter.price - amount
    where id = sourceAccountId;

    update barter
    set price = barter.price + amount
    where id = destinationAccountId;

    commit;
end
$$;

call transfer(1,2,500);

select * from barter;

create table barter
(
    id    serial primary key,
    name  varchar(55),
    price integer
);

insert into barter(name, price) values ('name', 1000);
insert into barter(name, price) values ('name1', 1000);
