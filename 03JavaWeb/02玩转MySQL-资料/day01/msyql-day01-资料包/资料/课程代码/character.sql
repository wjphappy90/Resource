-- 插入中文数据

insert into my_teacher values('张三',34);
insert into my_teacher values('李四',35);

-- mysql.exe告知Mysqld.exe自己的字符集规则
set names gbk;

-- 查看系统保存的三种关系处理字符集
show variables like 'character_set%';

-- 修改变量
set character_set_client = gbk;
set character_set_results = gbk;

create table my_charset(
name varchar(10) charset gbk, -- 为当前字段设定字符集
nickname varchar(1) charset utf8
)charset utf8; -- 表示表中如果字段本身没有字符集那么才有utf8

-- 查看所有字符集
show character set;