<?php
	$msg = '';
	if(!empty($_POST)){
		$user = $_POST['user'];
		$pwd1 = $_POST['pwd1'];
		$pwd2 = $_POST['pwd2'];
		function register($user,$pwd1,$pwd2){
			//验证
			if(strlen($user)<6||strlen($user)>20) return '用户名在6-20字之间';
			if(strlen($pwd1)<6||strlen($pwd1)>20) return '密码在6-20字之间';
			if($pwd1!=$pwd2)                      return '两次密码不一致';
			//连接数据库
			$link = mysql_connect('localhost:3306','root','123');
			mysql_query('set names utf8');
			mysql_query('use my_db');
			$result = mysql_query("select * from user where user_name='{$user}'");
			$rw = mysql_fetch_assoc($result);
			if(!empty($rw)) return '用户名已存在';
			$result = mysql_query("insert into user (user_name,password) values('{$user}','{$pwd1}')");
			if($result===false) return '插入失败';
			header('Location:./index.php');
		}
		
		$msg = register($user,$pwd1,$pwd2);
	}
?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="./public/bootstrap/css/bootstrap.min.css">
	<style type="text/css">
		form{width: 500px;margin: 50px auto;}
		h2.title{width: 500px;margin: 50px auto;}
	</style>
</head>
<body>
	<h2 class="title">注册页面</h2>
	<?php if(!empty($msg)){ ?>
		<div class="alert alert-danger" role="alert" style="width: 500px;margin:0 auto;"><?php echo $msg; ?></div>
	<?php } ?>
	<form action="" method="post">
		<div class="form-group">
   			<label for="exampleInputEmail1">用户名：</label>
    		<input type="text" class="form-control" id="exampleInputEmail1" placeholder="用户名" name="user">
 		 </div>
 		 <div class="form-group">
   			<label for="exampleInputEmail1">密码：</label>
    		<input type="password" class="form-control" id="exampleInputEmail1" placeholder="密码" name="pwd1">
 		 </div>
 		  <div class="form-group">
   			<label for="exampleInputEmail1">确认密码：</label>
    		<input type="password" class="form-control" id="exampleInputEmail1" placeholder="确认密码" name="pwd2">
 		 </div>
 		 <input type="submit" value="注册" class="btn btn-primary"/>
		<a href="./login.php" class="btn btn-danger">登录</a>
		
	</form>
</body>
</html>