<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.setAttribute("name", "aaa"); // 添加属性
	
	session.setAttribute("name", "bbb"); // 属性替换
	
	session.removeAttribute("name"); // 属性移除
%>
</body>
</html>