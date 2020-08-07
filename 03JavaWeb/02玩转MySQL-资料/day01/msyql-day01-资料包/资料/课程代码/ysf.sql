create table ysf1(
int_1 int,
int_2 int,
int_3 int,
int_4 int)charset utf8;


insert into ysf1 values(100,-100,0,default);


-- 算术运算
select int_1 + int_2,int_1 - int_2,int_1 * int_2,int_1 / int_2,int_2 / int_3,int_2 / 6,int_4 / 5 from ysf1;


-- mysql中没有规定select必须有数据表
select '1' <=> 1, 0.02 <=> 0,0.02 <> 0;

-- 查找年龄区间
select * from my_student where stu_age between 20 and 30;
select * from my_student where stu_age between 30 and 20;

-- 逻辑与解决
select * from my_student where stu_age >= 20 and stu_age <= 30;

-- 查找身高高于170的或者年龄大于20岁的学生
select * from my_student where stu_height >= 170 or stu_age >= 20;


-- 知道学生信息
select * from my_student where stu_id in ('stu0001','stu0004','stu0007');

-- 查询为空数据
select * from my_int where int_6 is null;

-- 获取所有姓小的同学
select * from my_student where stu_name like '小%';
select * from my_student where stu_name like '小_';	-- 匹配单名