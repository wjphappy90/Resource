package com.itheima.hessian.service.impl;

import com.itheima.hessian.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public String sayHello(String name) {
        return "hello"+name;
    }


}
