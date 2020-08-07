package com.itheima.jdk11;

import java.lang.reflect.Field;

/**
 * JEP 181 :基于嵌套的访问控制
 */
public class Demo02 {
    public static void main(String[] args) {
        new Outter().new Inner().test();
    }
}

class Outter{
    private int outInt;
    // 成员内部类
    public class Inner{
        public void test(){
            try{
                System.out.println("outInt:"+ outInt);

                // 模拟JDK 11之前使用反射技术访问外部类的私有成员：报出错误
                // 模拟JDK 11开始之后使用反射技术访问外部类的私有成员：没有出现错误
                Class c = Outter.class;
                // 得到外部类的私有成员变量对象
                Field f = c.getDeclaredField("outInt");
                f.set(Outter.this , 100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
