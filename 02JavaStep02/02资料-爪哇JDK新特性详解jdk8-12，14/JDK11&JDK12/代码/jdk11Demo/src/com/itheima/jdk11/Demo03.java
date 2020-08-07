package com.itheima.jdk11;

import java.util.*;

/**
 * 局部变量var类型推断
 */
public class Demo03 {


    public static void main(String[] args) {
        String name = "itheima";
        var name1 = "itheima";

        List<String> names = new ArrayList<>();
        var names1 = new ArrayList<>();

        var maps = new HashMap<>();
        maps.put("huawei" , 10);
        maps.put("Java" , 11);

        // 遍历Map集合：键值对的方式遍历
        var entries = maps.entrySet();
        for(var enter : entries){
            String key = (String) enter.getKey();
            Integer value = (Integer) enter.getValue();
        }

        // 演示Lambda表达式简化匿名内部类写法。
        List<Integer> scores = new ArrayList<>();
        Collections.addAll(scores , 9 , 10 , 2);
        // 接下来要对这个集合进行降序排序。
        scores.sort((@Deprecated var o1, @Deprecated var o2) -> o2 - o1);
        System.out.println(scores);

        /**
         - var a;  这样不可以, 因为无法推断.
         - 类的属性的数据类型不可以使用var
         - var不同于js,类型依然是静态类型，var不可以在lambda表达式中混用。
         */
        // var a ;
        var a = "sss";
        //a = 1;

    }
}
