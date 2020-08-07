package com.itheima.test12;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 定义一个注解：Book
 * 包含属性：String value()   书名
 * 包含属性：double price()  价格，默认值为 100
 * 包含属性：String[] authors() 多位作者
 1. 定义类在成员方法上使用Book注解
 2. 解析获得该成员方法上使用注解的属性值。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Book{
    String value();
    double price();
    String[] authors();
}

public class Test12 {
    @Book(value = "西游记", price = 99, authors = {"吴承恩", "白求恩"})
    public void sell() {

    }

    public static void main(String[] args) throws Exception {
        Class c = Test12.class;
        Method m = c.getMethod("sell");
        if (m.isAnnotationPresent(Book.class)) {
            Book b = m.getAnnotation(Book.class);
            System.out.println(b);
        }
    }
}