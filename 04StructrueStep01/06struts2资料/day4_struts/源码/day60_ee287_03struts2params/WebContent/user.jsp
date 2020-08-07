<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>
<%--请求参数封装：类型转换失败的处理方式
<form action="${pageContext.request.contextPath}/demo3.action" method="post">
	姓名：<input type="text" name="username" /><s:fielderror fieldName="username"/><br/>
	年龄：<input type="text" name="age"/><s:fielderror fieldName="age"/><br/>
	生日：<input type="text" name="birthday"/><s:fielderror fieldName="birthday"/><br/>
	爱好：<input type="checkbox" name="hobby" value="吃饭"/>吃饭
		<input type="checkbox" name="hobby" value="睡觉"/>睡觉
		<input type="checkbox" name="hobby" value="写代码"/>写代码
		<s:fielderror fieldName="hobby"/><br/>
	<input type="submit" value="提交"/>
</form> --%>

<s:form action="demo3">
	<s:textfield name="username" label="姓名"/>
	<s:textfield name="age" label="年龄"/>
	<s:textfield name="birthday" label="生日"/>
	<s:submit value="提交"/>
</s:form>
</body>
</html>