package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * spring boot工程都有一个启动引导类，这是工程的入口类
 * 并在引导类上添加@SpringBootApplication
 */
@SpringBootApplication
// 扫描mybatis所有的业务mapper接口
//@MapperScan("com.itheima.mapper")
@MapperScan("com.itheima.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
