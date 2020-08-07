
insert into my_gbk values('张三'),('李四'),('王五');


create table my_student(
stu_id varchar(10) primary key comment '主键，学生ID',
stu_name varchar(10) not null  comment '学生姓名'
)charset utf8;

insert into my_student values
('stu0001','张三'),
('stu0002','张四'),
('stu0003','张五'),
('stu0004','张六');

insert into my_student values('stu0004','小婷');
-- 冲突更新
insert into my_student values('stu0004','小婷') on duplicate key update stu_name = '小婷';


replace into my_student values('stu0001','夏洛');


create table my_simple(
name char(1) not null
)charset utf8;

insert into my_simple values('a'),('b'),('c'),('d');

-- 蠕虫复制
insert into my_simple(name) select name from my_simple;