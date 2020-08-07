

-- 将数据表挂到数据库下
create table mydatabase2.class(
name varchar(10)
);

-- 进入数据库，创建表
use mydatabase2;
create table teacher(
name varchar(10)
);

-- 使用表选项
create table student(
name varchar(10)
)charset utf8;

-- 在test数据库下创建一个与teacher一样的表
use test;

create table teacher like mydatabase2.teacher;


-- 查看所有表
show tables;


-- 查看匹配数据表
show tables like 'c%';

-- 显示表结构
describe class;

desc teacher;

show columns from student;

-- 查看表创建语句
show create table student;


show create table student\G

-- 修改表选项
alter table student charset gbk;


-- 数据库中数据表名字通常有前缀：取数据库的前两个字母加上下划线
rename table student to my_student;

-- 给学生表增加age字段
alter table my_student add column age int;

-- 增加字段：放到第一个字段
alter table my_student add id int first;

-- 修改字段名
alter table my_student change age nj int;

-- 修改字段类型
alter table my_student modify name varchar(20);

-- 删除字段
alter table my_student drop nj;

-- 删除表名
drop table class;

drop table teacher,my_student;
