-- 创建过程

create procedure my_pro1()
select * from my_student;

-- 修改语句结束符
delimiter $$
create procedure my_pro2()
begin
	-- 求1到100之间的和
	declare i int default 1;
	-- declare sum int default 0;	-- 局部变量
	set @sum = 0;			-- 会话变量

	-- 开始循环获取结果
	while i <= 100 do
		-- 求和
		set @sum = @sum + i;
		set i = i + 1;
	end while;

	-- 显示结果
	select @sum;
end
$$
delimiter ;


-- 删除过程
drop procedure my_pro;



-- 创建三个外部变量
set @n1 = 1;
set @n2 = 2;
set @n3 = 3;

-- 创建过程
-- 修改语句结束符
delimiter $$
create procedure my_pro3(in int_1 int,out int_2 int,inout int_3 int)
begin
	-- 查看三个传入进来的数据的值
	select int_1,int_2,int_3;

	-- 修改三个变量的值
	set int_1 = 10;
	set int_2 = 100;
	set int_3 = 1000;

	select int_1,int_2,int_3;
	-- 查看会话变量
	select @n1,@n2,@n3;

	-- 修改会话变量
	set @n1 = 'a';
	set @n2 = 'b';
	set @n3 = 'c';

	select @n1,@n2,@n3;
end
$$
delimiter ;

-- 调用过程
call my_pro3(@n1,@n2,@n3);