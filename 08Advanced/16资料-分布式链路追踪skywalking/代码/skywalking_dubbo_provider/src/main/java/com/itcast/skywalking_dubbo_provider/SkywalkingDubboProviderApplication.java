package com.itcast.skywalking_dubbo_provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//添加dubbo生效注解
@EnableDubboConfiguration
public class SkywalkingDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkywalkingDubboProviderApplication.class, args);
    }

}
