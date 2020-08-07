create table my_enum(
gender enum('男','女','保密')
)charset utf8;

insert into my_enum values('男');
insert into my_enum values('女');
insert into my_enum values('男');

insert into my_enum values('male');

-- 将字段按照数值输出
select gender + 0 from my_enum;

insert into my_enum values(3);


create table my_set(
hobby set('篮球','足球','羽毛球','乒乓球','网球','橄榄球','冰球','高俅')
--           1      1      1         1       1       1       1      1
)charset utf8;

insert into my_set values('篮球,乒乓球,冰球');
--                          10010010
--  存储转换		    01001001	===》 1 + 8 + 64 = 73

insert into my_set values('高俅,足球,篮球,乒乓球,冰球');
--                          11010011
--  存储转换		    11001011	===》 1 + 2 + 8 + 64 + 128 = 203

-- 以数值方式查看集合数据
select hobby + 0 from my_set;

insert into my_set values(255);


create table my_varchar(
name varchar(65535)
)charset utf8;

-- utf8 65535 / 3 = 21845  如果采用varchar存储：需要2个额外的字节来保存长度
-- gbk  65535 / 2 = 32767 | 1 如果采用varchar存储：需要额外2个字节

create table my_utf(
name varchar(21844)
)charset utf8;

create table my_gbk(
name varchar(32766)
)charset gbk;