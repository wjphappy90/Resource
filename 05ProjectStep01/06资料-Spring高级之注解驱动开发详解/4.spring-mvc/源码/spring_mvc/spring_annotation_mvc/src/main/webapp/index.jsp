<%@page contentType="text/html; UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<body>
<!--入门案例的请求
<a href="${pageContext.request.contextPath}/hello">SpringMVC基于servlet3.0规范纯注解开发的入门</a>
<hr/>-->



<!--RequestMapping注解的使用-->
<%--<a href="${pageContext.request.contextPath}/springmvc/useRequestMapping?name">RequestMapping注解的使用</a>
<form action="${pageContext.request.contextPath}/springmvc/useRequestMapping" method="post">
    <input type="text" name="name" value="123">
    <input type="submit" value="RequestMapping注解的使用 Post方式请求">
</form>

<a href="springmvc/useRequestMapping?name">RequestMapping注解的使用</a>
<form action="springmvc/useRequestMapping" method="post">
    <input type="text" name="name" value="123">
    <input type="submit" value="RequestMapping注解的使用 Post方式请求">
</form>
<hr/>--%>


<!--RequestParam注解的使用
<a href="useParam1?name=test&age=18">RequestParam注解的使用之基本类型和String类型的入参</a>
<a href="useRequestParam?page=1">RequestParam注解的使用</a>-->
<form action="useParam2" method="post">
    用户名：<input type="text" name="username"><br/>
    密码：<input type="text" name="password"><br/>
    年龄：<input type="text" name="age"><br/>
    性别：<input type="text" name="gender"><br/>
    <%--生日：<input type="text" name="birthday"><br/>--%>
    <input type="submit" value="提交">
</form>
<hr/>




<!--InitBinder注解的使用
<form action="useInitBinder" method="post">
    用户名：<input type="text" name="username"><br/>
    密码：<input type="text" name="password"><br/>
    年龄：<input type="text" name="age"><br/>
    性别：<input type="text" name="gender"><br/>
    生日：<input type="text" name="birthday"><br/>
    <input type="submit" value="提交">
</form>
<hr/>-->


<!--RequestHader和CookieValue注解的使用
<a href="useRequestHeader">RequestHeader注解的使用</a>
<br/>
<a href="useCookieValue">CookieValue注解的使用</a>
<hr/>-->


<!--ModelAttribute注解的使用
<a href="useModelAttribute?name=test">ModelAttribute注解的使用</a>
<hr/>-->

<!--SessionAttribute和SessionAttributes注解的使用
<a href="useSessionAttributes">SessionAttributes注解的使用</a>
<br/>
<a href="useSessionAttribute">SessionAttribute注解的使用</a>


<!--ExceptionHandler注解的使用
<a href="useExceptionHandler">ExcpetionHandler注解的使用</a>
<hr/>-->


<!--RequestBody注解的使用
<script src="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
    //页面加载事件
    $(function () {
        //给Id为useRequestBodyAjax超链接绑定一个点击事件
        $("#useRequestBodyAjax").click(function () {
            alert("点击事件绑定成功");
            $.ajax({
                url:"useRequestBody",
                type:"post",
                // data:"username=test&age=18&gender=male",
                data:'{"username":"test","age":25,"gender":"male"}',//json
                contentType:"application/json",
                dataType:"text",
                success:function (data) {
                    alert(data);
                }
            });
        });
    })
</script>

<a href="#" id="useRequestBodyAjax">RequestBody注解的使用</a>

<a href="useRequestBody">ResponseBody注解的使用</a>
<a href="useResponseBody">ResponseBody注解的使用2</a>

<hr/>
-->

<!--SpringMVC中的拦截器
<a href="${pageContext.request.contextPath}/sayHello">SpringMVC中的拦截器</a>-->
</body>
</html>
