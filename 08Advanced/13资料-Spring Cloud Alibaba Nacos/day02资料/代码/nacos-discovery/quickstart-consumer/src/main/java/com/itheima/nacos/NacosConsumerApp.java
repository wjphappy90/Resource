package com.itheima.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Administrator
 * @version 1.0
 **/

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApp.class,args);
    }
}
