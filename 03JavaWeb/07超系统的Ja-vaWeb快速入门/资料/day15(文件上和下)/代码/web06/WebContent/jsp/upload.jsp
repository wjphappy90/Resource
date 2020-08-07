<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>文件上传</h1>
<h3>${ msg }</h3>
<!-- 文件上传三要素
		* 表单需要是post提交
		* 表单中需要文件上传项，必须有name的属性和值
		* 表单的enctype属性必须是multipart/form-data
 -->
 <form action="${ pageContext.request.contextPath }/UploadServlet" method="post" enctype="multipart/form-data">
 	文件描述:<input type="text" name="info"><br/>
 	文件上传:<input type="file" name="upload"><br/>
 	<input type="submit" value="上传"/>
 </form>
</body>
</html>