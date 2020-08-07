-- 插入数据到数据表

create table my_teacher(
name varchar(10),
age int
)charset utf8;


insert into my_teacher (name,age) values('Jack',30);

insert into my_teacher (age,name) values(49,'Tom');

insert into my_teacher (name) values('Han');

insert into my_teacher values('Lilei',28);

-- 获取所有数据
select * from my_teacher;

-- 获取指定字段数据
select name from my_teacher;

-- 获取年龄为30岁的人的名字
select name from my_teacher where age = 30;

-- 删除年龄为30岁的老师
delete from my_teacher where age = 30;

-- 更新年龄Han
update my_teacher set age = 28 where name = 'Han';