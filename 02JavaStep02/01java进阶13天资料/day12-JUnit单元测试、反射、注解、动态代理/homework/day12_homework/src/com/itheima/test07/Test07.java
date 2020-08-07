package com.itheima.test07;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 1. 定义一个Person类，包含属性name、age。
 2. 使用反射的方式创建一个实例、调用构造函数初始化name、age。
 使用反射方式调用setName方法对姓名进行设置，不使用setAge方法直接使用反射方式对age赋值。
 */
public class Test07 {
    public static void main(String[] args) throws Exception, SecurityException {
        //1.获取Person类的字节码对象
        Class clazz = Person.class;
        //2.利用反射获取有参构造方法
        Constructor constructor  = clazz.getConstructor(int.class,String.class);
        //3.调用构造方法,给属性初始化
        Person person =  (Person)constructor.newInstance(30,"灭绝师太");
        System.out.println(person);
        //4.使用反射方式调用setName方法对名称进行设置
        Method setNameMethod = clazz.getMethod("setName", String.class);
        setNameMethod.invoke(person, "张三丰");
        //5.不使用setAge方法直接使用反射方式对age赋值。
        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(person, 50);
        System.out.println(person);
    }
}
class Person {
    private int age;
    private String name;
    public Person() {
    }
    public Person(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }
}
