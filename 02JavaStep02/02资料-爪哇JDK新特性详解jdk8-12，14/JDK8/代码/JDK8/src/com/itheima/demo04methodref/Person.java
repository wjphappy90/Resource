package com.itheima.demo04methodref;

public class Person {
    private String name;
    private int age;

    public Person() {
        System.out.println("执行无参构造");
    }

    public Person(String name, int age) {
        System.out.println("执行有参构造: " + name + ", " + age);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
