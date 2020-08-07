package com.itheima.demo05stream;

public class Person2 {
    private String name;

    public Person2() {
    }

    public Person2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                '}';
    }
}
