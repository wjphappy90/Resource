<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>登录页面</h1>
<%
	/**
	* 判断request域中是否有错误信息：（第一次进入登录页面的时候，没有错误信息）
	* * 如果有错误信息：显示错误信息
	*/
	String msg = "";
	if(request.getAttribute("msg") != null){
		// 有错误信息：显示错误信息:
		msg = (String)request.getAttribute("msg");
	}
%>
<h3><font color="red"><%= msg %></font></h3>
<form action="/web02_login/LoginServlet" method="post">
	<table border="1" width="400">
		<tr>
			<td>用户名</td>
			<td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="登录"/></td>
		</tr>
	</table>
</form>
</body>
</html>