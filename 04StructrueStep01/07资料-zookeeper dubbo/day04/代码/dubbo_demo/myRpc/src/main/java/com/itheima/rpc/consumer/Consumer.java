package com.itheima.rpc.consumer;

import com.itheima.rpc.protocol.Invocation;
import com.itheima.rpc.provider.service.HelloService;

public class Consumer {

    public static void main(String[] args) {

        //封装一个invocation
        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello2",
                new Object[]{"学IT,来黑马"}, new Class[]{String.class});

        //远程调用服务
        String result = new HttpClient().post("localhost", 8080, invocation);

        System.out.println("远程调用执行的结果result="+result);
    }
}
