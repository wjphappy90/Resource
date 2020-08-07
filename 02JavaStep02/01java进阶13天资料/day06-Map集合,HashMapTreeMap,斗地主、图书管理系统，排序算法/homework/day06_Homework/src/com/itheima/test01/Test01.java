package com.itheima.test01;

import java.util.HashMap;

public class Test01 {
    public static void main(String[] args) {
        // 1.创建HashMap
        HashMap<String, String> hm = new HashMap<String, String>();

        // 2.使用put添加元素
        hm.put("黄晓明", "Baby");
        hm.put("邓超", "孙俪");
        hm.put("李晨", "范冰冰");
        hm.put("大黑牛", "范冰冰");

        // 3.使用put修改元素
        String v1 = hm.put("李晨", "白百合");

        // 4.使用get获取元素
        String string = hm.get("大黑牛");

        // 5.使用remove删除元素
        String v2 = hm.remove("大黑牛");
        System.out.println(v2);

        // 6.打印集合中的元素
        System.out.println(hm);
    }
}
