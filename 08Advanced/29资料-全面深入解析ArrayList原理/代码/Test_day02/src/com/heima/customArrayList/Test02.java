package com.heima.customArrayList;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * 测试 set 和 get 方法
 */
public class Test02 {
    public static void main(String[] args) {
        //创建自定义集合对象
        MyArrayList<String> list = new MyArrayList<String>();

        //添加数据
        list.add("黑马程序员");
        list.add("传智播客");
        list.add("传智大学");
        list.add("XXX");

        System.out.println(list.set(0, "长沙黑马程序员"));
        System.out.println(list);

        System.out.println("----------");
        System.out.println(list.remove(3));
        System.out.println(list);
    }
}
