package com.itheima.test02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
	现在有一个map集合如下:{1="张三丰",2="周芷若",3="汪峰",4="灭绝师太"}
		要求:
		1.将map集合中的所有信息显示到控制台上
		2.向该map集合中插入一个编码为5姓名为李晓红的信息
	 	3.移除该map中的编号为1的信息
	 	4.将map集合中编号为2的姓名信息修改为"周林"
 */
public class Test03 {
    public static void main(String[] args) {
        // 1.定义HashMap,编号作为key,姓名作为value
        Map<Integer,String> map = new HashMap<Integer, String>();

        // 2.使用put方法添加元素
        map.put(1, "张三丰");
        map.put(2, "周芷若");
        map.put(3, "汪峰");
        map.put(4, "灭绝师太");

        //	3.使用keySet+增强for迭代map中的元素,并打印
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            String value = map.get(key);
            System.out.println(key + " -- " + value);
        }
        // 4.使用put向该map集合中插入一个编码为5姓名为李晓红的信息
        map.put(5, "李晓红");
        // 5.使用remove移除该map中的编号为1的信息
        map.remove(1);
        // 6.使用put将map集合中编号为2的姓名信息修改为"周林"
        map.put(2, "周林");
        System.out.println(map);
    }
}