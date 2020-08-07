package com.itheima.demo02copyof;

import java.util.*;

public class Demo02 {
    public static void main(String[] args) {
        // 学习集合新增的copyof方法
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        List<String> copyOfList = List.copyOf(list);
        for (String s : copyOfList) {
            System.out.println(s);
        }
        // copyOf会将集合中的元素复制到一个新集合中,而这个集合是不能去增删改,返回的是不可变的集合
        // System.out.println(copyOfList.getClass());
        // copyOfList.add("dd");

        System.out.println("--------------");
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");

        Set<String> copyOfSet = Set.copyOf(set);
        for (String s : copyOfSet) {
            System.out.println(s);
        }
        // copyOfSet.add("cc");

        System.out.println("-------------");
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");

        Map<String, String> copyOfMap = Map.copyOf(map);
        Set<Map.Entry<String, String>> entrySet = copyOfMap.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + "::" + entry.getValue());
        }

        // copyOfMap.put("k1", "v13");
    }
}
