package com.itheima.demo01lambda;

import java.util.ArrayList;
import java.util.Collections;

public class Demo05Lambdaomit {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("刘德华", 58, 174));
        persons.add(new Person("张学友", 58, 176));
        persons.add(new Person("刘德华", 54, 171));
        persons.add(new Person("黎明", 53, 178));

        Collections.sort(persons, (o1, o2) -> o2.getAge() - o1.getAge());

        persons.forEach(t -> System.out.println(t));
    }
}
