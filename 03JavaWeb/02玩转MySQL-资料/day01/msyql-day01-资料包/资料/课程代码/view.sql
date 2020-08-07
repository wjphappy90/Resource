-- 创建视图

create view student_class_v as
select s.*,c.name from my_student as s left join
my_class as c
on 
s.class_id = c.class_id;

-- 使用视图
select * from student_class_v;

-- 修改视图
alter view student_class_v as
select * from my_student as s left join
my_class as c
using(class_id);

-- 删除视图
drop view student_class_v;

-- 创建简单视图
create view class_v as select * from my_class;

-- 向视图插入数据
insert into class_v values(5,'5班');
insert into class_v (class_id) values(null); -- name字段不能为空，却没有给值

-- 修改视图数据
update class_v set name = '五班' where class_id = 5;

-- 删除视图数据
delete from class_v where class_id = 5;


create view student_v as
select * from my_student where stu_age >= 18 with check option;

update student_v set stu_age = 16 where stu_id = 'stu0001';


create algorithm=merge view student_v1 as
select * from my_student order by stu_height desc;

create algorithm=temptable view student_v2 as
select * from my_student order by stu_height desc;


-- 分组统计
select * from student_v1 group by class_id;
select * from student_v2 group by class_id;