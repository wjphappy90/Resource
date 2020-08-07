

-- select选项

select all * from my_simple; -- select *

select distinct * from my_simple;

-- 字段别名
select distinct name as name1,name name2 from my_simple;


select * from my_int,my_set;


select * from (select int_1,int_8 from my_int) as int_my;


-- 分组
select * from my_student group by class_id; -- 根据班级id进行分组


-- 使用聚合函数：按照班级统计每班人数，最大年龄，最矮的身高，平均年龄
select class_id,count(*),max(stu_age),min(stu_height),avg(stu_age) from my_student group by class_id;
select class_id,group_concat(stu_name),count(*),max(stu_age),min(stu_height),avg(stu_age) from my_student group by class_id;
