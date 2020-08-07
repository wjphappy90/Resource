<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>个人中心</title>
	<style type="text/css">
		.box{width: 900px;height: 500px;border: 1px solid #ccc;box-shadow: 0 0 8px #ccc;margin: 50px auto;}
		h2{text-align: center;}
		.center-box{margin: 50px auto;width: 900px;text-align: center;}
		.class1{width: 500px;height: 50px;border: 1px solid #ccc;margin: 10px auto;}
	</style>
	<link rel="stylesheet" type="text/css" href="./public/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="box">
		<h2>我是个人中心</h2>
		<div class="center-box">
			<?php
				//连接数据库
				$link = mysql_connect('localhost','root','123');
				mysql_query("set names utf8");
				mysql_query("use my_db");
				//获得用户表数据
				$sql = "select * from user";
				//执行SQL语句
				$result = mysql_query($sql);
				//计算字段列数
				$num = mysql_num_fields($result);
			?>
			<table class="class1" border="1" cellpadding="0" >
				<?php
					//显示字段列表 
					for($i=0;$i<$num;$i++){
						$name = mysql_field_name($result,$i);
						echo "<th>$name</th>";
					}
					
					//显示数据
					while($res = mysql_fetch_assoc($result)){
						echo "<tr>";
						foreach ($res as $k=>$v) {
							echo "<td>$v</td>";
						}
						echo "<tr>";
					}
					
				?>
					
			</table>
			<a href="./index.php" class="btn btn-danger">退出到首页</a>
		</div>
	</div>
</body>
</html>
