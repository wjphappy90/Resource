package com.itheima.test09;

import java.util.*;

/**
 使用lambda表达式对List，Set，Map集合进行遍历。
 */
public class Demo01 {

        public static void main(String[] args){
            testList();
            testSet();
            testMap();
        }

        // 使用lambda表达式遍历list集合
        public static void testList(){
            // 创建List集合
            List<String> list = new ArrayList<String>();
            list.add("jack");
            list.add("rose");
            list.add("lily");
            list.add("lucy");
            // 使用lambda表达式遍历集合
            list.forEach((str)->System.out.println(str));
        }


        // 使用lambda表达式遍历set集合
        public static void testSet(){
            // 创建Set集合
            HashSet<String> set = new HashSet<String>();
            set.add("jack");
            set.add("rose");
            set.add("lily");
            set.add("lucy");
            // 使用lambda表达式遍历集合
            set.forEach((str)->System.out.println(str));
        }

        // 使用lambda表达式遍历map集合
        public static void testMap(){
            // 创建map集合
            Map<String,String> map = new HashMap<String,String>();
            map.put("name","jack");
            map.put("gender","男");
            // 使用lambda表达式遍历集合
            map.forEach((key,value)->System.out.println(key+"="+value));
        }
}
