package com.itheima.test03;
import java.lang.reflect.Constructor;

public class Test03 {
    /*
     * 3.定义一个Student类，用反射去创建一个Student对象,使用两种方式
     * 通过Class对象的方法创建。
     * 通过Constructor对象的方法创建。
     */
    public static void main(String[] args) throws Exception {
        // 获得Class对象
        Class c = Class.forName("com.itheima.test03.Student");
        //方式1：通过Class对象的方法创建。
        Object obj1 = c.newInstance();
        System.out.println(obj1);
        //方式2：通过Constructor对象的方法创建。
        Constructor cons = c.getConstructor(int.class,String.class);
        Object obj2 = cons.newInstance(23,"jack");
        System.out.println(obj2);
    }
}

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
