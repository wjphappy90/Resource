<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ValueStack的数据存取</title>
</head>
<body>
<%--获取值栈的数据也需要借助于struts2的标签库
使用s:property获取
获取值栈的数据，是直接写属性名称，得到的就是属性的值。
OGNL表达式的找法，是从栈顶逐个属性名称开始查找，只要找到之后，就不再继续查找，而是返回结果。
 --%>
姓名：<s:property value="name"/><br/>
年龄：<s:property value="age"/><br/>
性别：<s:property value="gender"/><br/>
<hr/>
<%--获取指定位置的属性 --%>
获取第一个name:<s:property value="[0].name"/><br/>
获取第二个name:<s:property value="[1].name"/>
<hr/>
<%--如果使用s:property标签，没有写value属性，取的是栈顶对象 --%>
<s:property/>
<%--如果没有操作值栈时，默认的栈顶对象是：当前执行的Action对象 --%>
<hr size="5" color="red"/>
<%--s:property在通过OGNL表达式获取数据时，所调用的方法：ValueStack中的findValue(String expr); --%>
<% 
ActionContext context = ActionContext.getContext();
ValueStack vs = context.getValueStack();
Object o1 = vs.findValue("[0].name");
out.println(o1);
out.println("<br/>");
Object o2 = vs.findValue("[1].name");
out.print(o2);
out.println("<br/>");
Object o3 = vs.findValue("#application.applicationMap");
out.print(o3);
%>









<%--借助struts2的标签库来查看ContextMap中的内容 --%>
<s:debug></s:debug>

</body>
</html>