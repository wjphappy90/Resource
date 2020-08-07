<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL获取数据</h1>
<%
	// pageContext.setAttribute("name", "张三");
	// request.setAttribute("name", "李四");
	session.setAttribute("name", "王五");
	application.setAttribute("name", "赵六");
%>

<%= pageContext.getAttribute("name") %> - ${ pageScope.name }<br/> 
<%= request.getAttribute("name") %> - ${ requestScope.name }<br/>
<%= session.getAttribute("name") %> - ${ sessionScope.name }<br/>
<%= application.getAttribute("name") %> - ${ applicationScope.name }<br/>
<h3>EL的简写</h3>
${ name }
</body>
</html>