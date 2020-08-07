<?php 
//显示表数据

//从上个页面接收，数据库，和数据表
$db = $_GET['db'];
$table = $_GET['table'];

//连接数据库
$link = mysql_connect('localhost','root','123');

//设置字符集编码
mysql_query("set names utf8");

//选择数据库
mysql_query("use $db");

//查看表结构
$sql = "select * from $table;";
//执行SQL语句
$result = mysql_query($sql);
//显示表结构
//获取总列数
$fileds = mysql_num_fields($result);

//显示字段列表
echo "<table border='1' cellspacing='0'>";
for($i=0;$i<$fileds;$i++){
	$name = mysql_field_name($result,$i);
	echo "<th>".$name."</th>";
}

//显示字段内容
while($res = mysql_fetch_assoc($result)){
	echo "<tr>";
	foreach ($res as $key => $value) {
		echo "<td>".$value."</td>";
	}
	echo "</tr>";
}

echo "</table>";


