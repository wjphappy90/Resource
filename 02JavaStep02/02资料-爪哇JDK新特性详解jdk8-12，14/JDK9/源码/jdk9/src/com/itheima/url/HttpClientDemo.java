package com.itheima.url;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;

//需求：使用HttpClient访问黑马服务器，得到黑马首页
public class HttpClientDemo {

    public static void main(String[] args) throws Exception {
        //1. 创建HttpClient的对象
        HttpClient httpClient = HttpClient.newHttpClient();
        //2. 创建请求的构造器
        HttpRequest.Builder builder = HttpRequest.newBuilder(new URI("http://www.itheima.com"));
        //3. 使用请求构造器构建请求，并且设置请求的参数
        HttpRequest request = builder.header("user-agent", "heima").GET().build();
        //4. 使用HttpClient发送请求，并且得到响应的对象
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandler.asString());
        //5. 查看响应对象的信息
        System.out.println("响应状态码："+ response.statusCode());
        System.out.println("响应的信息："+response.body());
    }
}
