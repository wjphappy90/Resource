package com.itheima.microservice.service2.service;

import com.itheima.microservice.service2.api.ProviderService;

/**
 * @author Administrator
 * @version 1.0
 **/
@org.apache.dubbo.config.annotation.Service
public class ProviderServiceImpl implements ProviderService {
    public String service() {
        return "Provider invoke";
    }
}
