package com.itheima.nacos.controller;

import com.itheima.nacos.client.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
public class ConsumerController {

    //动态代理对象，内部远程调用服务生产者
    @Autowired
    ProviderClient providerClient;


    @GetMapping("/service")
    public String service(){
        //远程调用
        String providerResult = providerClient.service();

        return "consumer invoke" + "|" + providerResult;

    }
}
