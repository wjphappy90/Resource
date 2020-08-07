<%@page contentType="text/html; UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<body>
<h2>执行成功！</h2>

<%System.out.println("success.jsp执行了");%>

<h3>${requestScope.message}<h3>
</body>
</html>
