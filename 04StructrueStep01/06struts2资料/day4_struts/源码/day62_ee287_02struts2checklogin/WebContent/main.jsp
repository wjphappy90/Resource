<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎访问XXX论坛主页</title>
</head>
<body>
<h1>欢迎访问XXX论坛，请前往对应的版块发帖</h1>
<%--只有登录成功的用户，才能点击下面的连接，前往对应的版块，否则就前往登录页面 --%>
<hr/>
<h3>
<a href="${pageContext.request.contextPath}/demo1.action">娱乐版块</a>
</h3>
<h3>
<a href="${pageContext.request.contextPath}/demo2.action">体育版块</a>
</h3>
<h3>
<a href="${pageContext.request.contextPath}/demo3.action">军事版块</a>
</h3>
</body>
</html>