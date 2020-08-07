-- 在字段后增加主键属性
create table my_pri1(
username varchar(10) primary key
)charset utf8;

create table my_pri2(
username varchar(10),
primary key(username)
)charset utf8;

create table my_pri3(
username varchar(10)
)charset utf8;

-- 增加主键
alter table my_pri3 add primary key(username);

-- 删除主键
alter table my_pri3 drop primary key;


create table my_score(
student_no char(10),
course_no char(10),
score tinyint not null,
primary key(student_no,course_no)
)charset utf8;

insert into my_score values('00000001','course001',100);
insert into my_score values('00000002','course001',90);
insert into my_score values('00000001','course002',95);
insert into my_score values('00000002','course001',98);