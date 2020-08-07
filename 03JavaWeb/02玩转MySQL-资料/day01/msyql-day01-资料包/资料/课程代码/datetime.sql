create table my_date(
d1 date,
d2 time,
d3 datetime,
d4 timestamp,
d5 year
)charset utf8;

insert into my_date values(
'1900-01-01','12:12:12','1900-01-01 12:12:12','1999-01-01 12:12:12',69);
insert into my_date values(
'1900-01-01','12:12:12','1900-01-01 12:12:12','1999-01-01 12:12:12',2020);
insert into my_date values(
'1900-01-01','12:12:12','1900-01-01 12:12:12','1999-01-01 12:12:12',70);


update my_date set d1 = '2000-01-01' where d5 = 2069;

insert into my_date values(
'1900-01-01','512:12:12','1900-01-01 12:12:12','1999-01-01 12:12:12',70);


insert into my_date values(
'1900-01-01','5 12:12:12','1900-01-01 12:12:12','1999-01-01 12:12:12',70);

