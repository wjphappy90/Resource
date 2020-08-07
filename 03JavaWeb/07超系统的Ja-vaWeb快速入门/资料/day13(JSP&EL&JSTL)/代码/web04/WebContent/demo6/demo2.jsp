<%@page import="java.util.*"%>
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
<h3>获取数组的数据</h3>
<%
	String[] arrs = {"aa","bb","cc"};
	pageContext.setAttribute("arrs", arrs);
%>
${ arrs[0] }
${ arrs[1] }
${ arrs[2] }
<h3>获取List集合的数据</h3>
<%
	List<String> list = new ArrayList<String>();
	list.add("11");
	list.add("22");
	list.add("33");
	pageContext.setAttribute("list", list);
%>
${ list[0] }
${ list[1] }
${ list[2] }
<h3>获取Map中的数据</h3>
<%
	Map<String,Integer> map = new HashMap<String,Integer>();
	map.put("aaa", 111);
	map.put("bbb", 222);
	map.put("ccc.ddd", 333);
	pageContext.setAttribute("map", map);
%>
${ map.aaa }
${ map.bbb }
${ map["ccc.ddd"] }
</body>
</html>