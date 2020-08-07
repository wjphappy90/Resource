package com.itheima.test03;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args){
        // 1.定义四种水果数组
        String[] fruit = { "苹果", "香蕉", "西瓜", "橘子" };
        // 2.创建随机数对象
        Random ran = new Random();
        // 3、定义HashMap,存放商品id和商品名称
        HashMap<String, String> hm = new HashMap<>();
        // 4.循环判断hm键值对个数是否小于水果个数
        while (hm.size() < fruit.length) {
            // 5.产生一个商品编号,是8个0-9的数
            StringBuilder id = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                id.append(ran.nextInt(10));
            }
            // 6、存储键值对
            hm.put(id.toString(), fruit[hm.size()]);
        }
        System.out.println(hm);
        // 7.让用户输入要查询的商品id
        System.out.println("请输入要查询商品的id:");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        // 8.根据id去map中查找对应的商品
        String product = hm.get(id);
        if (product == null) {
            // 9.没有找到商品打印:查无此商品
            System.out.println("查无此商品");
        } else {
            // 10.找到商品打印对应商品的信息
            System.out.println("根据商品号：" + id + "，查询到对应的商品为：" + product);
        }
    }
}
