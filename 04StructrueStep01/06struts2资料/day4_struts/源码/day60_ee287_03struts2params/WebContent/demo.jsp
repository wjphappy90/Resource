<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:debug></s:debug>
<%-- <form action="${pageContext.request.contextPath}/demo1.action" method="post">
	姓名：<input type="text" name="username"/><br/>
	年龄：<input type="text" name="age"/><br/>
	生日：<input type="text" name="birthday"/><br/>
	爱好：<input type="checkbox" name="hobby" value="吃饭"/>吃饭
		<input type="checkbox" name="hobby" value="睡觉"/>睡觉
		<input type="checkbox" name="hobby" value="写代码"/>写代码
		<br/>
	<input type="submit" value="提交"/>
</form>  --%>

<%-- <form action="${pageContext.request.contextPath}/demo2.action" method="post">
	姓名：<input type="text" name="user.username"/><br/>
	年龄：<input type="text" name="user.age"/><br/>
	生日：<input type="text" name="user.birthday"/><br/>
	爱好：<input type="checkbox" name="user.hobby" value="吃饭"/>吃饭
		<input type="checkbox" name="user.hobby" value="睡觉"/>睡觉
		<input type="checkbox" name="user.hobby" value="写代码"/>写代码
		<br/>
	<input type="submit" value="提交"/>
</form> --%>

<%-- <form action="${pageContext.request.contextPath}/demo3.action" method="post">
	姓名：<input type="text" name="username" value="user.username"/><br/>
	年龄：<input type="text" name="age"/><br/>
	生日：<input type="text" name="birthday"/><br/>
	爱好：<input type="checkbox" name="hobby" value="吃饭"/>吃饭
		<input type="checkbox" name="hobby" value="睡觉"/>睡觉
		<input type="checkbox" name="hobby" value="写代码"/>写代码
		<br/>
	<input type="submit" value="提交"/>
</form> --%>

<a href="${pageContext.request.contextPath}/demo.action">demo</a>
</body>
</html>