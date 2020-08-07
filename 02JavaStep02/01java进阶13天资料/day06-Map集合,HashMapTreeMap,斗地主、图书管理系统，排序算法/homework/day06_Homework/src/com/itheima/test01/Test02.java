package com.itheima.test01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Test02 {
    public static void main(String[] args) {
        // 1.创建HashMap
        HashMap<String, String> hm = new HashMap<String, String>();

        // 2.使用put添加元素
        hm.put("黄晓明", "Baby");
        hm.put("邓超", "孙俪");
        hm.put("李晨", "范冰冰");
        hm.put("大黑牛", "范冰冰");

        // 3.使用Map的keySet方法获取到所有的key
        Set<String> keySet = hm.keySet();

        // 4.使用增强for获取每个key
        for (String key : keySet) {
            System.out.println(key);
        }

        System.out.println("----------------");
        // 5.获取keySet的迭代器
        Iterator<String> itr = keySet.iterator();
        // 6.循环判断迭代器中是否有下一个元素
        while (itr.hasNext()) {
            // 7.使用迭代器获取每个key
            System.out.println(itr.next());
        }
    }
}
