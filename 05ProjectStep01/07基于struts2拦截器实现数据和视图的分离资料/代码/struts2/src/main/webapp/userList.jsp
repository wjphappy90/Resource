<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	width: 100%;
	border-collapse: collapse;
}

#customers td, #customers th {
	font-size: 1em;
	border: 1px solid #98bf21;
	padding: 3px 7px 2px 7px;
}

#customers th {
	font-size: 1.1em;
	text-align: left;
	padding-top: 5px;
	padding-bottom: 4px;
	background-color: #A7C942;
	color: #ffffff;
}

#customers tr.alt td {
	color: #000000;
	background-color: #EAF2D3;
}
</style>
</head>
<body>
	<table id="customers">
		<tr>
			<th>编号</th>
			<th>用户名</th>
			<th>年龄</th>
			<th>地址</th>
		</tr>
		<s:iterator value="users">
			<tr>
				<td><s:property value="id"/></td>
				<td><s:property value="username"/></td>
				<td><s:property value="age"/></td>
				<td><s:property value="address"/></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>