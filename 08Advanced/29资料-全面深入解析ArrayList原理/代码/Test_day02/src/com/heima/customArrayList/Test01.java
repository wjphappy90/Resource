package com.heima.customArrayList;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 */
public class Test01 {
    public static void main(String[] args) {

        //创建自定义集合对象
        MyArrayList<String> list = new MyArrayList<String>();

        //添加数据
        list.add("黑马程序员");
        list.add("传智播客");
        list.add("传智大学");
        list.add("传智大学");

        //调用toString方法
        String str = list.toString();
        System.out.println(str);
    }
}
