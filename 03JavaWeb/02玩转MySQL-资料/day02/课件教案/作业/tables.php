<?php 
//显示所有表

//接收上一个页面传过来的数据库名称
$db = $_GET['db'];

//连接数据库
$link = mysql_connect('localhost','root','123');

//设置字符集编码
mysql_query("set names utf8");

//选择数据库
mysql_query("use $db");

//显示所有表
$sql = "show tables";

//执行SQL语句
$result = mysql_query($sql);


//循环显示
while($res = mysql_fetch_assoc($result)){
	foreach($res as $k=>$v){
		echo $v . "<a href='./table_desc.php?table=$v&db=$db'>查看表结构</a>"."&nbsp;"."<a href='./table_data.php?table=$v&db=$db'>查看表数据</a>" . "<br />";
	}
}

