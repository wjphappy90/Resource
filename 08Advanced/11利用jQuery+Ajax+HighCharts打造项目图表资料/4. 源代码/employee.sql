-- 创建员工表
create table employee (
	id int primary key auto_increment,
	name varchar(20) not null,
	gender char(1) default '男',
	salary double
);

-- 插入5条数据
insert into employee (name,gender,salary) values 
('孙悟空','男',8000),('邹丽丽','女',12000),('刘小轩','男',9000),('猪九戒','男',3000),('嫦娥','女',650);

select * from employee;