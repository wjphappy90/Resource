<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>用户列表</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/default/easyui.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/icon.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript">
	$(function() {
		//模拟第三方公司的请求，需要传递一个third参数
		$('#dg').datagrid({
			url : '${pageContext.request.contextPath}/userList.action?third=itcast',
			columns : [ [ {
				field : 'id',
				title : '编号',
				width : 100
			}, {
				field : 'username',
				title : '用户姓名',
				width : 100
			}, {
				field : 'age',
				title : '年龄',
				width : 100
			}, {
				field : 'address',
				title : '地址',
				width : 100
			} ] ],
			fitColumns : true
		});

	});
</script>
</HEAD>
<BODY>
	<table id="dg" width="98%"></table>
</BODY>
</HTML>
