package com.heima.arrayTest;

import java.util.ArrayList;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * ArrayList根据索引删除元素源码分析
 */
public class Test03 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("司理理");
        list.add("苏小小");
        list.add("李师师");

        String s = list.remove(1);
        System.out.println(s);
    }
}
