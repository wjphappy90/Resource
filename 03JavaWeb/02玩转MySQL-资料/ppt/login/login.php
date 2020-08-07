<?php 
	$msg = '';
	if(!empty($_POST)){
		$user = $_POST['user'];
		$pwd  = $_POST['password'];
		function login($user,$pwd){
			if(strlen($user)<6||strlen($user)>20) return '用户名在6到20位之间';
			if(strlen($pwd)<6||strlen($pwd)>20)   return '密码在6到20位之间';
			$link = @mysql_connect('localhost:3306','root','123');
			if($link===false) return '服务器维护中';
			mysql_query('set names utf8');
			mysql_query('use my_db');
			$ret = mysql_query("select * from user where user_name='{$user}' and password='{$pwd}' limit 1");
			$rw  = mysql_fetch_assoc($ret);
			if(empty($rw)) return '用户名或密码错误';
			header('Location:./member.php');
		}
		$msg = login($user,$pwd);
	}
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>登录</title>
	<link rel="stylesheet" type="text/css" href="./public/bootstrap/css/bootstrap.min.css">
	<style type="text/css">
		form{width: 500px;margin: 50px auto;}
		h2.title{width: 500px;margin: 50px auto;}
	</style>
</head>
<body>
	<h2 class="title">登录页面<a href="./index.php">返回首页</a></h2>
	<?php if($msg!=''){ ?>
		<div class="alert alert-danger" role="alert" style="width: 500px;margin:0 auto;"><?php echo $msg; ?></div>
	<?php } ?>
	<form action="" method="post">
		<div class="form-group">
   			<label for="exampleInputEmail1">用户名：</label>
    		<input type="text" class="form-control" id="exampleInputEmail1" placeholder="用户名" name="user">
 		 </div>
 		 <div class="form-group">
   			<label for="exampleInputEmail1">密码：</label>
    		<input type="password" class="form-control" id="exampleInputEmail1" placeholder="密码" name="password">
 		 </div>

		<input type="submit" value="登录" class="btn btn-success"/>
		<input type="button" value="注册" class="btn btn-primary" onclick="location.href='./register.php'"/>
	</form>
</body>
</html>
