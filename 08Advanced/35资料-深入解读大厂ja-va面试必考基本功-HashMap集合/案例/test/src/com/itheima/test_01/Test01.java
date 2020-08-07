package com.itheima.test_01;


import java.util.HashMap;

public class Test01 {
    public static void main(String[] args) {
        //创建HashMap集合对象
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("柳岩", 18);
        hm.put("杨幂", 28);
        hm.put("刘德华", 40);
        hm.put("柳岩", 20);
        System.out.println(hm);
        System.out.println("重地".hashCode());
        System.out.println("通话".hashCode());
    }
}
