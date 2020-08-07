-- 根据定义的身高变量，判定当前身高的所属的身材类型 

-- 	180 及以上 ----------> 身材高挑

--	170 - 180  ---------> 标准身材

--	170 以下  ----------> 一般身材
	
	
create procedure pro_test4()
begin
  declare height int default 175;
  declare description varchar(50) default '';
  if height >= 180 then
    set description='身材高挑';
  elseif height >= 170 and height < 180 then
    set description='标准身材';
  else
    set description='一般身材';
  end if;
  select concat('身高 ', height , '对应的身材类型为:',description);
end$
	
	
	
-- 根据传递的身高变量，判定当前身高的所属的身材类型 	

create procedure pro_test5(in height int)
begin
  declare description varchar(50) default '';
  if height >= 180 then
    set description='身材高挑';
  elseif height >= 170 and height < 180 then
    set description='标准身材';
  else
    set description='一般身材';
  end if;
  select concat('身高 ', height , '对应的身材类型为:',description);
end$	
	
	
-- 根据传入的身高变量，获取当前身高的所属的身材类型(返回值)

create procedure pro_test6(in height int , out description varchar(10))
begin
  if height >= 180 then
    set description='身材高挑';
  elseif height >= 170 and height < 180 then
    set description='标准身材';
  else
    set description='一般身材';
  end if;
end$
 

 
-- 给定一个月份, 然后计算出所在的季度

create procedure pro_test7(mon int)
begin
  declare result varchar(10);
  case
    when mon>=1 and mon <= 3 then
	  set result='第一季度';
	when mon>=4 and mon <= 6 then
	  set result='第二季度';
    when mon>=7 and mon <= 9 then
	  set result='第三季度';
	ELSE
	  set result='第四季度';
  end case;
  select concat('传递的月份为:',mon,', 计算出的结果为:',result) as content;
end$



-- 计算从1加到n的值 -- 累加
create procedure pro_test8(n int)
begin
  declare total int default 0;
  declare num int default 1;
  while num<=n do
    set total = total + num;
	set num = num + 1;
  end while;
  select total;
end$



-- 计算从1加到n的值 -------> repeat
create procedure pro_test9(n int)
begin
  declare total int default 0;
  repeat
    set total=total+n;
    set n=n-1;
    until n=0
  end repeat;
  select total;
end$


-- 计算从1加到n的值 ------> loop  ... leave
create procedure pro_test10(n int)
begin
  declare total int default 0;
  
  c:loop
    set total = total + n;
    set n = n -1;
	
	if n <= 0 then
	  leave c;
	end if;  
  end loop c;
  
  select total;
end$


-- 查询emp表中数据, 并逐行获取进行展示
create procedure pro_test11()
begin
  declare e_id int(11);
  declare e_name varchar(50);
  declare e_age int(11);
  declare e_salary int(11);
  declare emp_result cursor for select * from emp;
  
  open emp_result;
  
  fetch emp_result into e_id,e_name,e_age,e_salary;
  select concat('id=',e_id , ', name=',e_name, ', age=', e_age, ', 薪资为: ',e_salary);
  
  fetch emp_result into e_id,e_name,e_age,e_salary;
  select concat('id=',e_id , ', name=',e_name, ', age=', e_age, ', 薪资为: ',e_salary);
  
  fetch emp_result into e_id,e_name,e_age,e_salary;
  select concat('id=',e_id , ', name=',e_name, ', age=', e_age, ', 薪资为: ',e_salary);
  
  fetch emp_result into e_id,e_name,e_age,e_salary;
  select concat('id=',e_id , ', name=',e_name, ', age=', e_age, ', 薪资为: ',e_salary);
  
  fetch emp_result into e_id,e_name,e_age,e_salary;
  select concat('id=',e_id , ', name=',e_name, ', age=', e_age, ', 薪资为: ',e_salary);
  
  close emp_result;
end$


create procedure pro_test12()
begin
  declare e_id int(11);
  declare e_name varchar(50);
  declare e_age int(11);
  declare e_salary int(11);
  declare has_data int default 1;
  
  declare emp_result cursor for select * from emp;
  DECLARE EXIT HANDLER FOR NOT FOUND set has_data=0;
  
  open emp_result;
  
  repeat
    fetch emp_result into e_id,e_name,e_age,e_salary;
    select concat('id=',e_id , ', name=',e_name, ', age=', e_age, ', 薪资为: ',e_salary);
    until has_data = 0
  end repeat;
  
  close emp_result;
end$




-- 定义一个存储函数, 获取满足条件 (city) 的总记录数 ;
create function fun1(countryId int)
RETURNS int
begin
  declare cnum int ;
  
  select count(*) into cnum from city where country_id = countryId;
  
  return cnum;
end$

	
	
-- 通过触发器记录 emp 表的数据变更日志 emp_logs , 包含增加, 修改 , 删除 ; 	
create trigger emp_insert_trigger
after insert
on emp
for each row
begin
  
  insert into emp_logs(id,operation,operate_time,operate_id,operate_params) values(null,'insert',now(),new.id,concat('插入后(id:',new.id,', name:',new.name,', age:',new.age, ', salary: ', new.salary,')'));
  
end$
	
	
	

create trigger emp_update_trigger
after update
on emp
for each row
begin
  
  insert into emp_logs(id,operation,operate_time,operate_id,operate_params) values(null,'update',now(),new.id, concat('修改前(id:',old.id,', name:',old.name,', age:',old.age, ', salary: ', old.salary,'), 修改后(',new.id,', name:',new.name,', age:',new.age, ', salary: ', new.salary));
  
end$


create trigger emp_delete_trigger
after delete
on emp
for each row
begin
  
  insert into emp_logs(id,operation,operate_time,operate_id,operate_params) values(null,'delete',now(),old.id, concat('删除前(id:',old.id,', name:',old.name,', age:',old.age, ', salary: ', old.salary,')'));
  
end$
	
	
	
	
	
	
	
	
	
	
	
	