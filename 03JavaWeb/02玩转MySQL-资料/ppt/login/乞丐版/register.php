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
		<div class="alert alert-danger" role="alert" style="width: 500px;margin:0 auto;">错误提示</div>
	<form action="" method="">
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
		<a href="#" class="btn btn-danger">登录</a>
		
	</form>
</body>
</html>