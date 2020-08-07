package com.itheima.test01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Test04 {
    public static void main(String[] args) {
        // 1.创建HashMap
        HashMap<String, String> hm = new HashMap<String, String>();

        // 2.使用put方法添加元素
        hm.put("邓超", "孙俪");
        hm.put("李晨", "范冰冰");
        hm.put("刘德华", "柳岩");
        hm.put("黄晓明", "Baby");
        hm.put("谢霆锋", "张柏芝");

        // 3.使用keySet方法获取所有的键
        Set<String> keySet = hm.keySet();

        // 4.获取到keySet的迭代器
        Iterator<String> it = keySet.iterator();

        // 5.循环判断迭代器是否有下一个元素
        while (it.hasNext()) {
            // 6.使用迭代器next方法获取到一个键
            String key = it.next();

            // 7.通过一个键找到一个值
            String value = hm.get(key);

            // 8.输出键和值
            System.out.println(key + " - " + value);
        }
    }
}
