<?php 
//显示所有数据库

//连接数据库
$link = mysql_connect('localhost:3306','root','123');

//设置字符集编码
mysql_query("set names utf8");

//组装SQL语句
$sql = "show databases";

//执行SQL语句
$result = mysql_query($sql);

while($res = mysql_fetch_assoc($result)){
	foreach($res as $k=>$v){
		echo $v  . "<a href='./tables.php?db=$v'>查看表</a>". "<br />";
	} 
} 
