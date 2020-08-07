-- 交叉连接
select * from my_student cross join my_int;

-- 内连接
select * from my_student inner join my_class; -- 可以，没有条件，笛卡尔积
select * from my_student inner join my_class on class_id = id;
select * from my_student inner join my_class on my_student.class_id = my_class.id;
select * from my_student as s inner join my_class c on s.class_id = c.id;

select * from my_class c inner join my_student as s  on s.class_id = c.id;
select * from my_class c inner join my_student as s  where s.class_id = c.id;


select * from my_student as s left join my_class c on s.class_id = c.id;

select * from my_student as s right join my_class as c on s.class_id = c.id;
select * from my_class as c left join my_student as s on s.class_id = c.id;


-- 自然内连接
select * from my_student natural join my_class;

-- using关键字
select * from my_student left join my_class using(class_id);