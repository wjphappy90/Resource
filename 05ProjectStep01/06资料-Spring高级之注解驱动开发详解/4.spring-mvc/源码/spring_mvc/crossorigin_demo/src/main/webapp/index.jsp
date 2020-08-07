<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--异步请求-->
<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){//加载事件
        $("#testAjax").click(function(){
            $.ajax({
                type:"POST",
                url:"http://www.itheima.com/useCrossOrigin",
                dataType:"text",
                data:'{"username":"aaa","password":"1234","gender":"男","age":"18"}',
                contentType:"application/json",
                success:function(data){
                    alert(data);
                }
            });
        });
    });
</script>

<a href="#" id="testAjax">发送异步请求</a>

<img src="http://www.itheima.com/getImage">

<link href="http://www.itheima.com/getCss" type="text/css" rel="stylesheet">
<div>黑马程序员</div>
</body>
</html>
