<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>编辑客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<s:debug></s:debug>
<%--按照我们的设想，数据会在栈顶 --%>
 HTML客户名称：<input type="text" name="custName" value="${custName}"/>
<hr/>
Struts2客户名称：<s:textfield name="custName" value="%{custName}"/>
<hr/>
Struts2客户名称：<s:textfield name="custName"/>
</BODY>
</HTML>
