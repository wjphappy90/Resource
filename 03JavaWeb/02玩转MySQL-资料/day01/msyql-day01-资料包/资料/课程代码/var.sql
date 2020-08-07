-- 查看系统变量
select @@autocommit;


-- 会话修改系统变量
set autocommit = 0;

-- 全局修改系统变量
set global autocommit = 0;
set @@global.auto_increment_increment = 2;

-- 定义用户变量
set @name = 'Hello world';

-- 使用专用赋值符号
set @age := 50;

-- 通过查询数据为变量赋值
select @name := stu_name,@age := stu_age from my_student limit 1; 
select stu_name,stu_age from my_student order by stu_height desc limit 1 into @name,@age;

-- 查看自定义变量
select @name,@age;
