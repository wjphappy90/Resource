package com.itheima.jdk11;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

/**
 * JDK 11之后：Http Client
 */
public class Demo07 {
    /**
     * 发起同步请求
     */
    @Test
    public void send01() throws Exception {
        // 地址
        String url = "http://api.k780.com:88/?app=life.time&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json";
        // 1.创建一个HttpClient客户都对象
        HttpClient client = HttpClient.newHttpClient();

        // 2.创建一个请求对象：request ,封装地址，参数，请求方式（Get Post）
        // 注意：GET()方法的调用可以省略，默认就是get请求。
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)).GET().build();

        // 3.通过HttpClient对象发起request请求得到一个响应结果对象
        /**
         * 参数一：请求对象
         * 参数二：响应的结果处理成字符串结果。
         * 返回的是一个响应对象。
         */
        HttpResponse<String> response = client.send(request
                ,HttpResponse.BodyHandlers.ofString());

        // 4.得到响应码
        int code = response.statusCode();
        // 5.得到响应的结果数据：字符串
        String rs = response.body();
        // 6.输出结果
        System.out.println(code+" : " + rs);
    }

    /**
     * 发起异步请求
     */
    @Test
    public void send02(){
        // 地址
        String url = "http://api.k780.com:88/?app=life.time&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json";
        // 1.创建一个HttpClient客户都对象
        HttpClient client = HttpClient.newHttpClient();

        // 2.创建一个请求对象：request ,封装地址，参数，请求方式（Get Post）
        // 注意：GET()方法的调用可以省略，默认就是get请求。
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)).GET().build();

        // 3.通过客户端对象发起request的异步请求
        CompletableFuture<HttpResponse<String>> future =
                client.sendAsync(request,HttpResponse.BodyHandlers.ofString());

        // 4.异步：监听结果数据
        future.whenComplete((stringHttpResponse,throwable) -> {
                // 5.结果数据的处理
                if(throwable != null){
                    // 请求出错了
                    throwable.printStackTrace();
                }else{
                    int code = stringHttpResponse.statusCode();
                    String rs = stringHttpResponse.body();
                    System.out.println(code+"->"+rs);
                }
        }).join(); // 阻塞等待异步结果。

        System.out.println("结束程序!");
    }
}
