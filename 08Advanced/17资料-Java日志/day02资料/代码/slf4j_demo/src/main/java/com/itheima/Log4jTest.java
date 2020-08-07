package com.itheima;

import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4jTest {

    // 定义 log4j 日志记录器
    public static final Logger LOGGER = Logger.getLogger(Log4jTest.class);

    // 测试桥接器
    @Test
    public void test01()throws Exception{
        LOGGER.info("hello lgo4j");
    }
}
