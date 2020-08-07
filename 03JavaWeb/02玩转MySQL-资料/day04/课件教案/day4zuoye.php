第一题：

1, 查出“计算机系”的所有学生信息
	SELECT * FROM `学生表` AS x INNER JOIN `院系表` AS y ON x.`院系ID`=y.`院系ID` AND `院系名称`='计算机系'
2, 查出“孙悟空”所在的院系信息
	方法1：
	select * from `院系表` where 院系ID=(select 院系ID from `学生表` where 姓名='孙悟空')
	方法2：
	select `院系表`.* from `院系表` inner join `学生表` on `学生表`.院系ID=`院系表`.院系ID where 姓名='孙悟空'
3, 查出在“行政楼”办公的院系名称
	 select 院系名称 from `院系表` where 系办地址 like '%行政楼%'
4, 查出男生女生各多少人
	select `性别`,count(*) as c from `学生表` group by 性别
5, 查出人数最多的院系信息（注意会有相同人数的情况出现）	
	SELECT * FROM `院系表` WHERE `院系ID` in(
		SELECT `院系ID` FROM `学生表` GROUP BY `院系ID` HAVING COUNT(*) = (
			SELECT COUNT(*) FROM `学生表` GROUP BY `院系ID` ORDER BY COUNT(*) DESC LIMIT 1
		)
	)
6, 查出人数最多的院系的男女生各多少人（注意会有相同人数的情况出现）
	SELECT `院系ID`,性别,COUNT(*) AS 人数 FROM `学生表` WHERE `院系ID` in(
		SELECT `院系ID` FROM `学生表` GROUP BY `院系ID` HAVING COUNT(*) = (
			SELECT COUNT(*) FROM `学生表` GROUP BY `院系ID` ORDER BY COUNT(*) DESC LIMIT 1
		)
	)GROUP BY `院系ID`,`性别`
7,查出跟“孙悟空”同籍贯的所有人	
	SELECT 姓名 FROM `学生表` WHERE `籍贯`=(
		SELECT `籍贯` FROM `学生表` WHERE `姓名`='孙悟空'
	)
8,查出有“河北”人就读的院系信息。
	方法1：
	SELECT * from `院系表` WHERE `院系ID` in(
		SELECT `院系ID` FROM `学生表` WHERE 籍贯='河北'
	)
	方法2：
	SELECT DISTINCT y.* from `院系表` AS y INNER JOIN`学生表` AS x ON y.`院系ID`=x.`院系ID` WHERE 籍贯='河北'
9， 查出跟“河北女生”同院系的所有学生的信息
	SELECT * from `学生表` WHERE `院系ID`=(
		SELECT `院系ID` FROM `学生表` WHERE `籍贯`='河北' AND `性别`='女'
	)

第二题
1)查询选修了 MySQL 的学生姓名；
	SELECT name from stu where id in (
		SELECT stu_id from chengji as c inner join kecheng as k on c.kecheng_id=k.id where k.kecheng_name='Mysql' 
	)
2)查询 张三 同学选修了的课程名字；
	SELECT kecheng_name from kecheng where id in (
		SELECT kecheng_id from chengji as c INNER JOIN stu as s on c.stu_id=s.id and name='张三'
	)
3)查询只选修了1门课程的学生学号和姓名；
	SELECT name,id from stu where id in (
		SELECT stu_id from chengji as c inner join kecheng as k on c.kecheng_id=k.id GROUP BY stu_id HAVING count(*)=1
	)
4)查询选修了至少3门课程的学生信息；
	SELECT name,id from stu where id in (
		SELECT stu_id from chengji as c inner join kecheng as k on c.kecheng_id=k.id GROUP BY stu_id HAVING count(*)>=3
	)
5)查询选修了所有课程的学生；
	SELECT name,id from stu where id in (
		SELECT stu_id from chengji as c inner join kecheng as k on c.kecheng_id=k.id GROUP BY stu_id HAVING count(*)>=(
			SELECT count(*) from kecheng 
		)
	)
6)查询选修了课程的总人数；
	SELECT count(a.stu_id) from (SELECT DISTINCT stu_id stu_id from chengji) as a
7)查询所学课程至少有一门跟 张三 所学课程相同的学生信息。
	SELECT * from stu where id in (
	SELECT stu_id from chengji where kecheng_id in(
		SELECT kecheng_id from chengji where stu_id=(
			SELECT id from stu where name='张三'
		)
	)
	) and name <>'张三'
8)查询两门及两门以上不及格同学的平均分
	方法1：
	select stu_id,avg(score) from chengji where stu_id in(
		select stu_id from chengji WHERE score < 60 GROUP BY stu_id HAVING count(*)>=2
	)group by stu_id
	方法2： 
	select stu_id,avg(score) from chengji where stu_id in(
		select stu_id from chengji GROUP BY stu_id HAVING sum(score<60)>=2
	)

