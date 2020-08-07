<?php 
	/*
	//创建表
	create table user(
		id int primary key auto_increment,
		user_name varchar(30) not null default '',
		password varchar(36) not null default ''
	);
	 */
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>首页</title>
	<style type="text/css">
		.box{width: 900px;height: 500px;border: 1px solid #ccc;box-shadow: 0 0 8px #ccc;margin: 50px auto;}
		h2{text-align: center;}
		.center-box{margin: 50px auto;width: 900px;text-align: center;}
	</style>
	<link rel="stylesheet" type="text/css" href="./public/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="box">
		<h2>我是首页</h2>
		<div class="center-box">
			<a href="./login.php" class="btn btn-success btn-lg">登录</a>
			<a href="./register.php" class="btn btn-primary btn-lg">注册</a>
		</div>
	</div>
</body>
</html>
