<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL执行运算</h1>
<h3>执行算数运算</h3>
<%
	pageContext.setAttribute("n1", "10");
	pageContext.setAttribute("n2", "20");
%>

${ n1+n2 }

<h3>执行关系运算</h3>
${ n1 < n2 }  -- ${ n1 lt n2 } <br/>
${ n1 > n2 }  -- ${ n1 gt n2 } <br/>
${ n1 == n2 } -- ${ n1 eq n2 } <br/>
${ n1 >= n2 } -- ${ n1 ge n2 } <br/>
${ n1 <= n2 } -- ${ n1 le n2 } <br/>
${ n1 != n2 } -- ${ n1 ne n2 } <br/>

<h3>执行逻辑运算</h3>
<%
	pageContext.setAttribute("n3", "30");
	pageContext.setAttribute("n4", "40");
%>

${ (n1 < n2) && (n3 < n4)} -- ${ (n1 < n2) and (n3 < n4)} <br/>
${ (n1 < n2) || (n3 < n4)} -- ${ (n1 < n2) or (n3 < n4)} <br/>
${ !(n1 < n2) } -- ${ not (n1 < n2)} <br/>

<h3>执行三元运算</h3>
${ n1 < n2 ? "n1小于n2" : "n1不小于n2" }

<h3>空运算符</h3>
${ empty user }
</body>
</html>