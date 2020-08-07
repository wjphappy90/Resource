package com.itheima.ds_project01._04_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tanshuai on 2019/6/23.
 */
public class JdkStack {
    public static void main(String[] args) {
        List list;
        //创建栈对象
        Stack stack = new Stack();
        //数据入栈
        stack.push("itcast");
        stack.push("itheima");
        //数据出栈
        Object item = stack.pop();
        System.out.println(item);
    }
}
