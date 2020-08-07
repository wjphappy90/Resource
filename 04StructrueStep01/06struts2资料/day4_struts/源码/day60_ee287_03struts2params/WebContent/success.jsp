<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:debug></s:debug>
执行成功！
EL表达式获取：${name}
<hr/>
OGNL表达式获取：<s:property value="name"/>
<hr/>
HTML标签：<input type="text" name="username1" value="<s:property value='name'/>"/><br/>
HTML标签：<input type="text" name="username1" value="${name}"/><br/>
HTML标签：<input type="text" name="username1" value="%{name}"/>
<hr/>
struts2标签：<s:textfield name="username2" value="%{name}"/>
<hr/>
${today}
<br/>
<s:property value="today"/>
</body>
</html>