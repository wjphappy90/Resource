package com.itheima.demo10_lock_coarsing;

import java.util.Hashtable;

public class Demo01 {
    public static void main(String[] args) {
        // synchronized (Demo01.class) {
        //     System.out.println("aaa");
        // }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 100; i++) {
            sb.append("aa");
        }


        System.out.println(sb.toString());
    }
}
