package com.heima.arrayTest;

import java.util.LinkedList;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 */
public class Test04 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("孙悟空");
        list.add("猪八戒");
        list.add("白龙马");

        String value = list.remove(1);
        System.out.println(value);
    }
}
