<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>demo2.jsp中获取四个范围的数据</h1>
<%= pageContext.getAttribute("name") %>
<%= request.getAttribute("name") %>
<%= session.getAttribute("name") %>
<%= application.getAttribute("name") %>
</body>
</html>