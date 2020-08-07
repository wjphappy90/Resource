<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OGNL的最基本用法</title>
</head>
<body>
<%--要想使用OGNL表达式获取数据，此时需要借助struts2的标签库 
今天要使用s:property标签实现把数据输出到浏览器上
<s:property value=""/>
value属性的取值是一个OGNL表达式。
标签会把value属性取值所对应的内容输出到浏览器上
如果没有任何对应内容，则什么都不显示
--%>
OGNL的最基本用法：<s:property value="OGNLExpression"/><hr/>
<%--OGNL表达式和字符串的转换
表达式转成字符串
	%{''}  | %{""}
	可以把%{}去掉
字符串转成表达式
	%{}把字符串套起来
 --%>
OGNL转成一个普通的字符串：<s:property value="%{'OGNLExpression1'}"/><br/>
OGNL转成一个普通的字符串：<s:property value='%{"OGNLExpression2"}'/><br/>
OGNL转成一个普通的字符串：<s:property value='"OGNLExpression3"'/><br/>
OGNL转成一个普通的字符串：<s:property value="'OGNLExpression4'"/><br/>
<br/>
字符串转成一个OGNL表达式：<s:textfield name="username" value="%{testAAA}"/>
<hr/>
<%--OGNL表达式访问对象的方法 --%>
调用字符串的长度方法：<s:property value="'OGNLExpression1'.length()"/><br/>
调用字符串的转大写方法：<s:property value="'OGNLExpression1'.toUpperCase()"/><br/>
调用字符串的分隔方法：<s:property value="'OGNLExpression1'.split('E')"/><br/>
<hr/>
<%--OGNL表达式访问类的静态成员(静态属性) 
	访问静态属性需要按照固定的书写规范来写。
	规范是：
		@包名.包名...类名@静态属性名称
--%>
OGNL表达式访问静态属性：<s:property value="@java.lang.Integer@MAX_VALUE"/>
<hr/>
<%--OGNL表达式访问类的静态方法
	访问静态方法需要按照固定的书写规范来写。
	规范是：
		@包名.包名...类名@静态方法名称
--%>
OGNL表达式访问静态方法：<s:property value="@java.lang.Math@random()"/>
<hr/>
<%--OGNL表达式可以操作集合 List和Map --%>
HTML的单选按钮：<br/>
性别：<input type="radio" name="gender1" value="男">男
	<input type="radio" name="gender1" value="女">女
<br/>
<%--操作List集合 
s:radio标签的list取值就是一个OGNL表达式。
{}就表示创建了一个List集合
{'男','女'}===  List list = new ArrayList();  list.add("男"); list.add("女");
--%>
Struts2的单选按钮：<br/>
<s:radio list="{'男','女'}" name="gender2" label="性别"></s:radio>
<hr size="10" color="gray"/>
HTML的单选按钮：<br/>
性别：<input type="radio" name="gender3" value="male">男
	<input type="radio" name="gender3" value="female">女
<br/>
<%--操作Map集合
#{}就表示创建了一个Map集合。
#{key:value,key:value}
#{'male':'男','female':'女'}=== Map map = new HashMap();  map.put("male","男");  map.put("female","女");
--%>
Struts2的单选按钮：<br/>
<s:radio list="#{'male':'男','female':'女'}" name="gender4" label="性别"></s:radio>




</body>
</html>