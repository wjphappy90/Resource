package com.itheima.microservice.service1.service;

import com.itheima.microservice.service1.api.ConsumerService;
import com.itheima.microservice.service2.api.ProviderService;

/**
 * @author Administrator
 * @version 1.0
 **/
@org.apache.dubbo.config.annotation.Service //注解标记此类的方法暴露为dubbo接口
public class ConsumerServiceImpl implements ConsumerService {
    //注入service
    @org.apache.dubbo.config.annotation.Reference
    ProviderService providerService;
    //dubbo接口实现内容
    public String service() {
        //远程调用
        String service = providerService.service();
        return "Consumer invoke |" + service ;
    }
}
