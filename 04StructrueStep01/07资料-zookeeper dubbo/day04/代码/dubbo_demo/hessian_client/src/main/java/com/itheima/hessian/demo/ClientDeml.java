package com.itheima.hessian.demo;

import com.caucho.hessian.client.HessianProxyFactory;
import com.itheima.hessian.service.UserService;

import java.net.MalformedURLException;

public class ClientDeml {

    public static void main(String[] args) throws MalformedURLException {

        String url =  "http://localhost:8888/api/service";


        HessianProxyFactory hessianProxyFactory = new HessianProxyFactory();
        UserService userService = (UserService) hessianProxyFactory.create(UserService.class, url);
        System.out.println(userService.sayHello("传智黑马"));
    }
}
