<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Struts2对EL表达式的改变</title>
</head>
<body>
EL表达式：${name}	<%--从四个域中由小到大逐个搜索。调用的是pageContext的findAttribute方法 --%>
<hr/>
OGNL表达式：<s:property value="name"/>
<s:debug></s:debug>

</body>
</html>