package com.itcast.skywalking_plugins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {
    //此接口可以被追踪
    @GetMapping("/include")
    public String include(){
        return "include";
    }

    //此接口不可被追踪
    @GetMapping("/exclude")
    public String exclude(){
        return "exclude";
    }
}
