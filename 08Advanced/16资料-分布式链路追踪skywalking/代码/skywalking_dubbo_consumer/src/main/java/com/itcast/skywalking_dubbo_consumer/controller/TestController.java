package com.itcast.skywalking_dubbo_consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itcast.api.IHelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Reference(url = "dubbo://127.0.0.1:20880")
    private IHelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return helloService.hello();
    }
}
