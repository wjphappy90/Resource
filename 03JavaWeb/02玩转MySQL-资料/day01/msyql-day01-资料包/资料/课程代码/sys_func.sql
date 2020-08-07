Char_length()：判断字符串的字符数
Length()：判断字符串的字节数（与字符集）
Concat()：连接字符串
Instr()：判断字符在目标字符串中是否存在，存在返回其位置，不存在返回0
Lcase()：全部小写
Left()：从左侧指定位置开始截取字符串
Ltrim()：消除左边对应的空格
Mid()：从中间指定位置开始截取，如果不指定截取长度，直接到最后


select char_length('你好中国'),length('你好中国');

select concat('你好','中国'),instr('你好中国','中'),instr('你好中国','万');

select lcase('aBcD'),left('你好中国',2);

select ltrim(' a dbc '),mid('你好中国',2);


Now()：返回当前时间，日期 时间
Curdate()：返回当前日期
Curtime()：返回当前时间
Datediff()：判断两个日期之间的天数差距，参数日期必须使用字符串格式（用引号）
Date_add(日期,interval 时间数字 type)：进行时间的增加
	Type:day/hour/minute/second


select now(),curdate(),curtime();
select datediff('2010-10-10','1990-10-10');

select date_add('2000-10-10',interval 10 day),date_add('2000-10-10',interval 10 year),date_add('2000-10-10',interval 10 second);

Abs()：绝对值
Ceiling()：向上取整
Floor()：向下取整
Pow()：求指数，谁的多少次方
Rand()：获取一个随机数（0-1之间）
Round()：四舍五入函数

select abs(-1),ceiling(1.1),floor(1.1),pow(2,4),rand(),round(1.5);

Md5()：对数据进行md5加密（mysql中的md5与其他任何地方的md5加密出来的内容是完全相同的）
Version()：获取版本号
Databse()：显示当前所在数据库
UUID()：生成一个唯一标识符（自增长）：自增长是单表唯一，UUID是整库（数据唯一同时空间唯一）

select md5('a'),version(),database(),uuid();