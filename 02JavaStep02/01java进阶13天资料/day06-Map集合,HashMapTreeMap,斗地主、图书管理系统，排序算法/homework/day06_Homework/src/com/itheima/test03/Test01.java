package com.itheima.test03;


import java.io.IOException;
import java.util.HashMap;

/*
	已知Map中保存如下信息:{“及时雨”=”宋江”, “玉麒麟”=”卢俊义”, “智多星”=”吴用”},
	其中键表示水浒中人物的外号,value表示人物的姓名.
		1往Map中添加 “入云龙”=”公孙胜”, ”豹子头”=”林冲”两位好汉.
		2删除“玉麒麟”=”卢俊义”,
		3将key为“智多星”的value修改为null,
		4.将“及时雨”=”宋江”,修改为”呼保义”=” 宋江”
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        // 1.定义HashMap<String, String>key是外号,value是姓名
        HashMap<String, String> heroMap = new HashMap<String, String>();

        // 2.使用put方法添加默认的任务外号和姓名
        heroMap.put("及时雨", "宋江");
        heroMap.put("玉麒麟", "卢俊义");
        heroMap.put("智多星", "吴用");

        // 3.使用put方法往Map中添加 “入云龙”=”公孙胜”, ”豹子头”=”林冲”两位好汉.
        heroMap.put("入云龙", "公孙胜");
        heroMap.put("豹子头", "林冲");

        // 4.使用remove方法删除“玉麒麟”=”卢俊义”
        heroMap.remove("玉麒麟");

        // 5.使用put方法将key为“智多星”的value修改为null
        heroMap.put("智多星", null);

        // 6.使用remove方法删除“及时雨”=”宋江”
        heroMap.remove("及时雨");

        // 7.使用put添加”呼保义”=”宋江”
        heroMap.put("呼保义", "宋江");

        System.out.println(heroMap);
    }

}