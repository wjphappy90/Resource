<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL获取web开发常用对象</h1>
${ param.name }<!-- 相当于 request.getParameter("name") -->
${ paramValues.hobby[0] }${ paramValues.hobby[1] }<!-- 相当于 request.getParameterValues("hobby") -->
${ header["User-Agent"] }
${ initParam.username }
<br/>
${ pageContext.request.contextPath }
${ pageContext.request.remoteAddr }
</body>
</html>