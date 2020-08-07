package com.itheima.jdk11;

import java.io.IOException;
import java.util.List;
/**
 * JDK 11对于集合API的增强
 */
public class Demo05 {
    public static void main(String[] args) throws IOException {
        // 1.创建一个不可变集合对象
        List<String> names = List.of("猪八戒","猪刚鬣","唐僧");
        System.out.println(names);
        // names.add("孙悟空");

        // 2.可以把List集合转换成对应元素的类型
        // Object[] arrs1 = names.toArray();
        // JDK 11之前的方案
        //String[] arrs1 = names.toArray(new String[0]);
        // JDK 11之后的方法
        String[] arrs1 = names.toArray(String[]::new);
    }
}
