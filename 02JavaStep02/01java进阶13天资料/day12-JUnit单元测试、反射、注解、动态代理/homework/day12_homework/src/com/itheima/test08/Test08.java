package com.itheima.test08;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 已知一个类，定义如下
 package com.itheima;
 public class DemoClass {
     public void run() {
        System.out.println("welcome to heima!");
     }
 }
 (1)写一个Properties配置文件，配置文件内容如下：
 className=com.itheima.test08.DemoClass

 (2)写一个程序，读取这个Properties配置文件，获得类的完整名称并加载这个类，
 (3)用反射的方式运行run方法。
 */
public class Test08 {
    public static void main(String[] args) throws Exception {
        // 创建集合对象
        Properties props = new Properties();

        FileInputStream fis = new FileInputStream("day14_homework/config.properties");
        // 从属性文件中加载数据
        props.load(fis);
        // 获得类全名
        String className = (String) props.get("className");
        System.out.println(className);
        // 获得Class对象
        Class clazz = Class.forName(className);
        //利用反射创建一个对象
        Object obj = clazz.newInstance();
        //利用反射获取run方法
        Method runMethod = clazz.getMethod("run");
        //利用反射调用run方法
        runMethod.invoke(obj);
        fis.close();
    }
}
