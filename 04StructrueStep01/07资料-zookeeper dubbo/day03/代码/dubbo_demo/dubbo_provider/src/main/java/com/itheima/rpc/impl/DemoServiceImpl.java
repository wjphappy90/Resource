package com.itheima.rpc.impl;

import com.itheima.dubbo.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "hello"+name;
    }
}
