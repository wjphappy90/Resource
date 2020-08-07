-- 创建一个带自动增长的表

create table my_auto(
id int primary key auto_increment,
name varchar(10) not null comment '用户名',
pass varchar(50) not null comment '密码'
)charset utf8;

insert into my_auto values(null,'Tom','123456');

-- 修改auto_increment
alter table my_auto auto_increment  = 10;

-- 删除自增长
alter table my_auto modify id int;
-- 切记不要再次增加primary key

-- 查看自增长初始变量
show variables like 'auto_increment%';

-- 增加自增长
alter table my_auto modify id int auto_increment;

insert into my_auto values(3,'jack','123456');
insert into my_auto values(20,'jack','123456');

alter table my_auto auto_increment  = 10;