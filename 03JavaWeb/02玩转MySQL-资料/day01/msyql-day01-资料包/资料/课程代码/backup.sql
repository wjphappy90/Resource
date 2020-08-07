-- 单表数据备份与还原

-- 备份：student
-- 外部文件必须不存在：如果存在，那么失败
select * into outfile 'C:/server/temp/student.txt'

-- 字段处理
fields
   enclosed by '"'
   terminated by '|'

-- 行处理
lines
   starting by 'START:'
from my_student;


-- 还原
load data infile 'C:/server/temp/student.txt' into table my_student character set utf8
-- 字段处理
fields
   enclosed by '"'
   terminated by '|'

-- 行处理
lines
   starting by 'START:';


-- 利用mysqldump进行SQL备份

-- 整库备份
mysqldump.exe -hlocalhost -P3306 -uroot -proot mydatabase2 > c:/server/temp/mydatabase2.sql

-- 多表备份
mysqldump -uroot -proot mydatabase2 my_student my_int > c:/server/temp/student_int.sql

-- 还原数据
mysql -uroot -proot mydb < c:/server/temp/mydatabase2.sql

source c:/server/temp/student_int.sql;