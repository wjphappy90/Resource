<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>登录成功的页面！</h1>
<%
	Integer count = 0;
	// 判断，如果ServletContext中有值，获取并显示：
	if(this.getServletContext().getAttribute("count")!=null){
		count = (Integer)this.getServletContext().getAttribute("count");
	}
%>
<h3>登录成功的总人数：<%= count %></h3>
</body>
</html>