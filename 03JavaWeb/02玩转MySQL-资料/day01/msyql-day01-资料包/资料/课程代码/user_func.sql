-- 创建自定义函数

-- 修改语句结束符
delimiter $$
create function my_func1() returns int
begin
	return 10;
end
-- 结束
$$

-- 修改语句结束符（改回来）
delimiter ;


-- 最简函数
create function my_func2() returns int
return 100;

-- 最简函数
create function my_func3(int_1 int,int_2 int) returns int
return int_1 + int_2;

-- 查看所有函数
show function status;

-- 查看函数创建语句
show create function my_func1;

-- 调用函数
select my_func1(),my_func2(),my_func3(100,1000);

-- 删除函数
drop function my_func1;


-- 创建一个自动求和的函数

-- 修改语句结束符
delimiter $$
-- 创建函数
create function my_sum(end_value int) returns int
begin
	-- 声明变量（局部变量）：如果使用declare声明变量：必须在函数体其他语句之前
	declare res int default 0;
	declare i int default 1;

	-- 循环处理
	mywhile:while i <= end_value do
		-- 判断当前数据是否合理
		if i % 5 = 0 then
			-- 5的倍数不要
			set i = i + 1;
			iterate mywhile;
		end if;

		-- 修改变量：累加加过
		set res = res + i;	-- mysql中没有++
		set i = i + 1;
	end while mywhile;

	-- 返回值
	return res;

end
-- 结束
$$
-- 修改语句结束符
delimiter ;

-- 调用函数
select my_sum(100),my_sum(-100);


set @name = '张三';

create function my_func4() returns char(4)
return @name;