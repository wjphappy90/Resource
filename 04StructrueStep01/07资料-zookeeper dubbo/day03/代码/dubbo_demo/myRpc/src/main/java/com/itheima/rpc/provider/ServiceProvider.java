package com.itheima.rpc.provider;

import com.itheima.rpc.protocol.HttpServer;
import com.itheima.rpc.provider.service.HelloService;
import com.itheima.rpc.provider.service.impl.HelloServiceImpl;
import com.itheima.rpc.registry.NativeRegistry;
import com.itheima.rpc.registry.URL;

public class ServiceProvider {

    public static void main(String[] args) {

        //创建URL
        URL url = new URL("localhost", 8080);

        //注册中心中注册服务
        NativeRegistry.regist(url, HelloService.class.getName(), HelloServiceImpl.class);

        //启动并暴露服务
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(),url.getPort());

    }
}
