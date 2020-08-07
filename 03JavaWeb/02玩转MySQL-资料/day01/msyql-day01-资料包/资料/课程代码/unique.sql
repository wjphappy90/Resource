-- 唯一键

create table my_unique1(
id int primary key auto_increment,
username varchar(10) unique
)charset utf8;

create table my_unique2(
id int primary key auto_increment,
username varchar(10),
unique key(username)
)charset utf8;

create table my_unique3(
id int primary key auto_increment,
username varchar(10)
)charset utf8;

alter table my_unique3 add unique key(username);

insert into my_unique1 values(null,default);
insert into my_unique1 values(null,default);
insert into my_unique1 values(null,default);

insert into my_unique1 values(null,'army');
insert into my_unique1 values(null,'army');

alter table my_unique2 drop index username;
