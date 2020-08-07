-- 创建数据库
create database mydatabase;

create database mydatabase2 charset gbk;

-- 显示所有数据库
show databases;

-- 查看以my开头的数据库
show databases like 'my%';

-- 查看数据库创建语句
show create database mydatabase;

-- 选择数据库
use mydatabase;

-- 修改数据库字符集
alter database mydatabase charset gbk;

-- 删除数据库
drop database mydatabase;