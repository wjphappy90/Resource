package com.itheima.memory.heap;

import java.util.ArrayList;
import java.util.List;
/*
java.lang.OutOfMemoryError: Java heap space
-Xmx8m
-Xmx100m
 */
public class Demo01 {
    public static void main(String[] args) {
        int count = 0;
        try {
            List<String> list = new ArrayList<String>();
            String s = "itheima";
//            for(int i =0; i<20; i++){
//                list.add(s);
//                s += s;
//                count++;
//            }
            while (true) {
                list.add(s);
                s += s;
                count++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(count);
        }
    }
}