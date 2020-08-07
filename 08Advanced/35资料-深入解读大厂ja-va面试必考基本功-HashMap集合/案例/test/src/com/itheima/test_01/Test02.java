package com.itheima.test_01;


import java.util.*;

public class Test02 {
    public static void main(String[] args) {
        //创建HashMap集合对象
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("柳岩", 18);
        hm.put("杨幂", 28);
        hm.put("刘德华", 40);
        hm.put("柳岩", 20);
        //调用方法
//        method(hm);
//        method_1(hm);
//        method_2(hm);
        method_3(hm);
    }
    //jdk8以后使用Map接口中的默认方法：
    /*
        default void forEach​(BiConsumer<? super K,? super V> action)
            对此映射中的每个条目执行给定的操作，直到所有条目都被处理或操作引发异常。
            参数：
                BiConsumer 消费接口：
                抽象方法：void accept​(T t, U u) 对给定的参数执行此操作。
                        参数：
                            t key
                            u value
     */
    private static void method_3(HashMap<String, Integer> hm) {
        hm.forEach((key,value)->System.out.println(key+"---"+value));
    }

    //通过get方式  不建议使用 效率低
    private static void method_2(HashMap<String, Integer> hm) {
        Set<String> keys = hm.keySet();
        for (String key : keys) {
            Integer value = hm.get(key);
            System.out.println(key+"---"+value);
        }
    }

    //使用Iterator迭代器迭代
    private static void method_1(HashMap<String, Integer> hm) {
        Set<Map.Entry<String, Integer>> entries = hm.entrySet();
        for(Iterator<Map.Entry<String, Integer>> it = entries.iterator();it.hasNext();){
            Map.Entry<String, Integer> entry = it.next();
            System.out.println(entry.getKey()+"---"+entry.getValue());
        }
    }

    /*
        分别遍历Key和Values
     */
    private static void method(HashMap<String, Integer> hm) {
        //获取所有的key
        Set<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
        //获取所有的value
        Collection<Integer> values = hm.values();
        for (Integer value : values) {
            System.out.println(value);
        }
    }
}
