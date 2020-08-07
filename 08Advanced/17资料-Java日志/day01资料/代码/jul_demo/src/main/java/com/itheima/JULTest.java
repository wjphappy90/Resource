package com.itheima;

import org.junit.Test;

import java.util.logging.*;

public class JULTest {


    // 快速入门
    @Test
    public void testQuick()throws Exception{
        // 1.获取日志记录器对象
        Logger logger = Logger.getLogger("com.itheima.JULTest");
        // 2.日志记录输出
        logger.info("hello jul");

        // 通用方法进行日志记录
        logger.log(Level.INFO,"info msg");


        // 通过占位符 方式输出变量值
        String name = "itcast";
        Integer age = 13;
        logger.log(Level.INFO,"用户信息：{0},{1}",new Object[]{name,age});

    }

    // 日志级别
    @Test
    public void testLogLevel()throws Exception{
        // 1.获取日志记录器对象
        Logger logger = Logger.getLogger("com.itheima.JULTest");
        // 2.日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info"); // 默认日志输出级别
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

    }


    // 自定义日志级别
    @Test
    public void testLogConfig()throws Exception{
        // 1.获取日志记录器对象
        Logger logger = Logger.getLogger("com.itheima.JULTest");


        // 关闭系统默认配置
        logger.setUseParentHandlers(false);

        // 自定义配置日志级别
        // 创建ConsolHhandler 控制台输出
        ConsoleHandler consoleHandler = new ConsoleHandler();

        // 创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        // 进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);


        // 配置日志具体级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);


        // 场景FileHandler  文件输出
        FileHandler fileHandler = new FileHandler("/logs/jul.log");

        // 进行关联
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);

        // 2.日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info"); // 默认日志输出级别
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

    }



    // Logger对象父子关系
    @Test
    public void testLogParent()throws Exception{

        Logger logger1 = Logger.getLogger("com.itheima");
        Logger logger2 = Logger.getLogger("com");

        // 测试
        System.out.println(logger1.getParent() == logger2);
        // 所有日志记录器的顶级父元素 LogManager$RootLogger，name ""
        System.out.println("logger2 Parent:"+logger2.getParent() + ",name:" + logger2.getParent().getName());

        // 关闭默认配置
        logger2.setUseParentHandlers(false);

        // 设置logger2日志级别
        // 自定义配置日志级别
        // 创建ConsolHhandler 控制台输出
        ConsoleHandler consoleHandler = new ConsoleHandler();

        // 创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        // 进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger2.addHandler(consoleHandler);


        // 配置日志具体级别
        logger2.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        logger1.severe("severe");
        logger1.warning("warning");
        logger1.info("info");
        logger1.config("config");
        logger1.fine("fine");
        logger1.finer("finer");
        logger1.finest("finest");
    }



    // 加载自定义配置文件
    @Test
    public void testLogProperties()throws Exception{

//        // 读取配置文件，通过类加载器
//        InputStream ins = JULTest.class.getClassLoader().getResourceAsStream("logging.properties");
//        // 创建LogManager
//        LogManager logManager = LogManager.getLogManager();
//        // 通过LogManager加载配置文件
//        logManager.readConfiguration(ins);

        // 创建日志记录器
        Logger logger = Logger.getLogger("com.itheima");

        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");


        Logger logger2 = Logger.getLogger("test");

        logger2.severe("severe test");
        logger2.warning("warning test");
        logger2.info("info test");
        logger2.config("config test");
        logger2.fine("fine test");
        logger2.finer("finer test");
        logger2.finest("finest test");

    }

}
