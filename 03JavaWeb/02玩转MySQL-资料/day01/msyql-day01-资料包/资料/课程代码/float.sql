create table my_float(
f1 float,
f2 float(10,2)
)charset utf8;


insert into my_float values(123.123,12345678.90);

insert into my_float values(123.1234567,123456789.00);

insert into my_float values(123.1234567,99999999.99);

insert into my_float values(123.123,10e5);

create table my_decimal(
f1 float(10,2),
d1 decimal(10,2)
)charset utf8;

insert into my_decimal values(12345678.90,12345678.90);

insert into my_decimal values(99999999.99,99999999.99);
insert into my_decimal values(99999999.99,99999999.999);