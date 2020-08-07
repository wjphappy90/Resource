package com.itcast.skywalking_dubbo_provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.itcast.api.IHelloService;
import org.springframework.stereotype.Component;

@Service(interfaceClass = IHelloService.class)
@Component
public class HelloServiceImpl implements IHelloService {
    @Override
    public String hello() {
        return "hello skywalking";
    }
}
