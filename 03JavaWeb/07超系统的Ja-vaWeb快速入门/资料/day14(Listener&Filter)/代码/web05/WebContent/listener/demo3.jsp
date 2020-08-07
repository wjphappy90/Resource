<%@page import="com.itheima.listener.bean.Bean1"%>
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
	Bean1 bean1 = new Bean1();
	bean1.setName("张三");
	session.setAttribute("bean1", bean1); 
	
	session.removeAttribute("bean1");
%>
</body>
</html>