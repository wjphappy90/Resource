package com.itheima;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Log4j2Test {

    // 定义日志记录器对象
    public static final Logger LOGGER = LogManager.getLogger(Log4j2Test.class);

    // 快速入门
    @Test
    public void testQuick()throws Exception{
        // 日志消息输出
        LOGGER.fatal("fatal");
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("inf");
        LOGGER.debug("debug");
        LOGGER.trace("trace");


    }
}
