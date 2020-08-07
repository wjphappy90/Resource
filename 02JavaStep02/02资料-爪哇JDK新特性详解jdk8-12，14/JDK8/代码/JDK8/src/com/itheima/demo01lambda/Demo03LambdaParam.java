package com.itheima.demo01lambda;

import java.util.*;
import java.util.function.Consumer;

// 练习有参数有返回值的Lambda
public class Demo03LambdaParam {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("刘德华", 58, 174));
        persons.add(new Person("张学友", 58, 176));
        persons.add(new Person("刘德华", 54, 171));
        persons.add(new Person("黎明", 53, 178));

        // 对集合中的数据进行排序
        /*Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge(); // 升序排序
            }
        });*/

        Collections.sort(persons, (Person o1, Person o2) -> {
            return o2.getAge() - o1.getAge(); // 降序
        });

        for (Person person : persons) {
            System.out.println(person);
        }

        System.out.println("-----------");
        persons.forEach((t) -> {
            System.out.println(t);
        });
    }
}
