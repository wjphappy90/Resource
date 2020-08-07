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
	<h2 class="title">登录页面<a href="#">返回首页</a></h2>
		<div class="alert alert-danger" role="alert" style="width: 500px;margin:0 auto;">错误提示</div>
	<form action="" method="">
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
