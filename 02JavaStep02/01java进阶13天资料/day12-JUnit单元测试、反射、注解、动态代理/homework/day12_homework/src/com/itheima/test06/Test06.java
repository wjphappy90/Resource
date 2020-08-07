package com.itheima.test06;

import java.lang.reflect.Field;

/**
 按要求完成下面两个方法的方法体
 写一个方法，此方法可将obj对象中名为propertyName的属性的值设置为value.
 public void setProperty(Object obj, String propertyName, Object value){

 }
 写一个方法，此方法可以获取obj对象中名为propertyName的属性的值
 public Object getProperty(Object obj, String propertyName){

 }
 */
class Student {
    private int age;
    private String name;
    public Student() {

    }

    public Student(int age, String name) {
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
        return "Student [age=" + age + ", name=" + name + "]";
    }
}
public class Test06 {

    public static void main(String[] args) throws Exception {
        Student student = new Student(30,"张三");
        setProperty(student, "age", 25);
        System.out.println(student);

        Object obj = getProperty(student, "name");
        System.out.println(obj);
    }

    //给对象obj的名字为propertyName的属性设置为value
    public static void setProperty(Object obj, String propertyName, Object value) throws Exception{
        //1.获取obj的字节码对象
        Class clazz = obj.getClass();
        //2.获取propertyName属性对应的Field对象
        Field propertyNameField = clazz.getDeclaredField(propertyName);
        //3.设置成可访问的
        propertyNameField.setAccessible(true);
        //4.调用set方法给对象赋值
        propertyNameField.set(obj, value);

    }
    //给对象obj的名字为propertyName的属性设置为value
    public static Object getProperty(Object obj, String propertyName) throws Exception{
        //1.获取obj的字节码对象
        Class clazz = obj.getClass();
        //2.获取propertyName属性对应的Field对象
        Field propertyNameField = clazz.getDeclaredField(propertyName);
        //3.设置成可访问的
        propertyNameField.setAccessible(true);
        //4.调用get方法获取该对象对应属性的值
        return propertyNameField.get(obj);
    }
}

