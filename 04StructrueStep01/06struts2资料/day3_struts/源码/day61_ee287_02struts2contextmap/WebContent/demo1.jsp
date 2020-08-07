<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ActionContext的数据存取</title>
</head>
<body>
<%--借助struts2的s:property标签和OGNL表达式获取ActionContext存入的数据
我们现在获取的数据，都是在map中。
获取Map中的数据，OGNL表达式的写法：
	#key
	如果还想继续向下获取，使用.key的方式
--%>
<s:property value="#contextMap"/><br/>
<s:property value="#application.applicationMap"/><br/>
<s:property value="#session.sessionAttr"/>
<hr/>
<s:property value="#session.sessionMap"/>
<hr/>
<%--借助struts2的标签库来查看ContextMap中的内容 --%>
<s:debug></s:debug>

</body>
</html>