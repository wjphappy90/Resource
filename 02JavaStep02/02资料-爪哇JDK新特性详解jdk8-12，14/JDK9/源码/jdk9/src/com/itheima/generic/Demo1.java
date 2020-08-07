package com.itheima.generic;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(){};
        list.add("aa");
        list.add("bb");
        list.add("cc");
        System.out.println("集合的元素："+ list);
    }
}
