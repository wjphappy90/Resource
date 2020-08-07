package com.itheima;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(Slf4jTest.class);

    // 快速入门
    @Test
    public void test01()throws Exception{
        // 日志输出
        LOGGER.error("error");
        LOGGER.warn("wring");
        LOGGER.info("info"); // 默认级别
        LOGGER.debug("debug");
        LOGGER.trace("trace");

        // 使用占位符输出日志信息
        String name = "itheima";
        Integer age = 14;
        LOGGER.info("用户：{},{}",name,age);

        // 将系统的异常信息输出
        try {
            int i = 1/0;
        } catch (Exception e) {
           // e.printStackTrace();
            LOGGER.error("出现异常：",e);

        }
    }
}
