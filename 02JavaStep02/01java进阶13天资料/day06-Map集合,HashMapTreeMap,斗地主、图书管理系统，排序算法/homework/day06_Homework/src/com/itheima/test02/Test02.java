package com.itheima.test02;

import java.util.HashMap;
import java.util.Set;

/*
	研发部门有5个人，信息如下：（姓名-工资）【柳岩=2100, 张亮=1700, 诸葛亮=1800, 灭绝师太=2600, 东方不败=3800】,
		将以上员工的相关信息存放在适合的集合中,给柳岩涨工资300,迭代出每个元素的内容输出到控制台
 */
public class Test02 {
    public static void main(String[] args) {
        // 1.定义HashMap,姓名作为key,工资作为value
        HashMap<String, Integer> map = new HashMap<String,Integer>();

        // 2.使用put方法添加需要的元素
        map.put("柳岩", 2100);
        map.put("张亮", 1700);
        map.put("诸葛亮", 1800);
        map.put("灭绝师太", 2600);
        map.put("东方不败", 3800);

        // 3.获取到柳岩的工资
        int salary = map.get("柳岩");

        // 4.修改柳岩的工资为当前工资加上300
        map.put("柳岩", salary + 300);

        // 5.使用增强for+keySet迭代出每个员工的工资
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + " -- " + map.get(key));
        }
    }

}