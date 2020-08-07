package com.itheima.demo05stream;

import java.util.ArrayList;
import java.util.Collections;

/*
目标：体验集合操作数据的弊端

小结：
    1.集合操作数据的弊端?
        每个需求都要循环一次,还要搞一个新集合来装数据, 麻烦
 */
public class Demo01Intro {
    public static void main(String[] args) throws InterruptedException {
        // 一个ArrayList集合中存储有以下数据:张无忌,周芷若,赵敏,张强,张三丰
        // 需求:1.拿到所有姓张的 2.拿到名字长度为3个字的 3.打印这些数据
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");

        // 1.拿到所有姓张的 2.拿到名字长度为3个字的 3.打印这些数据
        list.stream()
                .filter((s) -> {
                    return s.startsWith("张");
                })
                .filter((s) -> {
                    return s.length() == 3;
                })
                .forEach((s) -> {
                    System.out.println(s);
                });

        System.out.println("-----------");
        // 1.拿到所有姓张的
        ArrayList<String> zhangList = new ArrayList<>(); // {"张无忌", "张强", "张三丰"}
        for (String name : list) {
            if (name.startsWith("张")) {
                zhangList.add(name);
            }
        }

        // 2.拿到名字长度为3个字的
        ArrayList<String> threeList = new ArrayList<>(); // {"张无忌", "张三丰"}
        for (String name : zhangList) {
            if (name.length() == 3) {
                threeList.add(name);
            }
        }

        // 3.打印这些数据
        for (String name : threeList) {
            System.out.println(name);
        }

    }
}
