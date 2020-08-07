<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>文件下载：超链接的方式</h1>
<h3><a href="${ pageContext.request.contextPath }/download/1.jpg">1.jpg</a></h3>
<h3><a href="${ pageContext.request.contextPath }/download/aa.zip">aa.zip</a></h3>

<h1>文件下载：手动编码的方式</h1>
<h3><a href="${ pageContext.request.contextPath }/DownloadServlet?filename=1.jpg">1.jpg</a></h3>
<h3><a href="${ pageContext.request.contextPath }/DownloadServlet?filename=aa.zip">aa.zip</a></h3>
<h3><a href="${ pageContext.request.contextPath }/DownloadServlet?filename=美女.jpg">美女.jpg</a></h3>
</body>
</html>