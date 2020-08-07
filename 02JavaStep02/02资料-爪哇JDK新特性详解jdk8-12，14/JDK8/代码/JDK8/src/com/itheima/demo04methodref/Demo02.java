package com.itheima.demo04methodref;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.function.*;

/*
方法引用的注意事项:
    1.被引用的方法,参数要和接口中抽象方法的参数一样
    2.当接口抽象方法有返回值时,被引用的方法也必须有返回值
 */
public class Demo02 {
    // 类型[]::new
    @Test
    public void test05() {
        /*Function<Integer, int[]> f1 = (Integer length) -> {
            return new int[length];
        };*/

        Function<Integer, int[]> f1 = int[]::new;

        int[] arr1 = f1.apply(10);
        System.out.println(Arrays.toString(arr1));
    }


    // 类名::new引用类的构造器
    @Test
    public void test04() {
        /*Supplier<Person> su1 = () -> {
            return new Person();
        };*/

        Supplier<Person> su1 = Person::new;

        Person person = su1.get();
        System.out.println("person = " + person);

        /*BiFunction<String, Integer, Person> bif = (String name, Integer age) -> {
            return new Person(name, age);
        };*/
        BiFunction<String, Integer, Person> bif = Person::new;
        Person p2 = bif.apply("凤姐", 18);
        System.out.println("p2 = " + p2);
    }

    
    // 类名::实例方法
    @Test
    public void test03() {
        /*Function<String, Integer> f1 = (String str) -> {
            return str.length();
        };*/

        // 类名::实例方法(注意:类名::类名::实例方法实际上会将第一个参数作为方法的调用者)
        Function<String, Integer> f1 = String::length;

        int length = f1.apply("hello");
        System.out.println("length = " + length);

        // BiFunction<String, Integer, String> f2 = String::substring;
        // 相当于这样的Lambda
        BiFunction<String, Integer, String> f2 = (String str, Integer index) -> {
            return str.substring(index);
        };
        String str2 = f2.apply("helloworld", 3);
        System.out.println("str2 = " + str2); // loworld
    }
    
    // 类名::静态方法
    @Test
    public void test02() {
        /*Supplier<Long> su = () -> {
            return System.currentTimeMillis();
        };*/

        Supplier<Long> su = System::currentTimeMillis;

        Long time = su.get();
        System.out.println("time = " + time);
    }

    // 对象::实例方法
    @Test
    public void test01() {
        Date now = new Date();

        /*Supplier<Long> su1 = () -> {
            return now.getTime();
        };*/

        // 使用方法引用
        Supplier<Long> su1 = now::getTime;

        Long aLong = su1.get();
        System.out.println("aLong = " + aLong);

        // 注意:方法引用有两个注意事项
        // 1.被引用的方法，参数要和接口中抽象方法的参数一样
        // 2.当接口抽象方法有返回值时，被引用的方法也必须有返回值
        // Supplier<Long> su3 = now::setTime;
        // su3.get();

        // Supplier<Long> su4 = now::setDate;
        // su4.get();
    }


}












