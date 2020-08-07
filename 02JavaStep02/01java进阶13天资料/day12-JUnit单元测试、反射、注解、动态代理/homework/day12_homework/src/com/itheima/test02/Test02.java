package com.itheima.test02;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test02 {
    /*
     * 2.ArrayList<Integer> list = new ArrayList<Integer>();
         在这个泛型为Integer的ArrayList中存放一个String类型的对象。
     */
    public static void main(String[] args) throws Exception {
        // 创建集合
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(111);
        list.add(222);
        list.add(333);

        // 通过反射获得Class对象
        // Class.forName("java.util.ArrayList");
        Class c = list.getClass();
        // 获得add方法对象
        Method addM = c.getMethod("add", Object.class);
        // 通过反射调用list对象的add方法
        addM.invoke(list, "aaaa");
        System.out.println(list);
    }
}
