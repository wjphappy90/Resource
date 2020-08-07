

-- 获取男生身高升序，女生身高降序
(select * from my_student where gender = '男' order by stu_height asc limit 10)
union 
(select * from my_student where gender = '女' order by stu_height desc limit 10);


select * from my_student
union 
select * from my_student;

select * from my_student
union all
select * from my_student;

select stu_id,stu_name,stu_height from my_student
union all
select stu_height,stu_id,stu_name from my_student;