package com.itheima.rpc.provider.service.impl;

import com.itheima.rpc.provider.service.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String msg) {
        System.out.println("hello"+msg);
    }

    @Override
    public String sayHello2(String msg) {
        return "hello"+msg;
    }

}
