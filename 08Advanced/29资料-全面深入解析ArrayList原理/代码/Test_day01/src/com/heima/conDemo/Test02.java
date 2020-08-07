package com.heima.conDemo;

import java.util.ArrayList;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * ArrayList有参构造源码分析一
 */
public class Test02 {
    public static void main(String[] args) {
        //这行代码ArrayList底层做了什么?
        ArrayList<String> list = new ArrayList<String>(5);
    }
}
