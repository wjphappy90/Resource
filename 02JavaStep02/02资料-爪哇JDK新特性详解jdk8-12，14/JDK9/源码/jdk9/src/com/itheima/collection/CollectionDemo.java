package com.itheima.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionDemo {

    public static void main(String[] args) {
        //1. 创建一个List的只读集合
        List list = List.of("张三","李四","王五");
        System.out.println("list集合的内容："+list);
        //2. 创建一个Set的只读集合
        Set set = Set.of("张三","李四","王五");
        System.out.println("set集合的内容:"+ set);
        //3. 创建一个Map的只读集合
        Map map = Map.of(1,"张三",2,"李四",3, "王五");
        System.out.println("map集合的内容:"+ map);

        //尝试修改只读集合的内容
        list.add("aa");

    }
}
