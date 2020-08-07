package com.heima.containsMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * ArrayList集合 包含方法
 *      public boolean contains(Object o) 判断集合是否包含指定元素
 */
public class Test01 {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<String>();
        //添加元素
        list.add("hello");
        list.add("PHP");
        list.add("Java");

        //需求:如果集合中没有JavaSE该元素,请添加一个JavaSE元素
        //method(list);

        //解决方式二:使用集合contains方法判断,根据判断的结果决定是否要添加元素
        if (!list.contains("JavaSE")){
            //添加元素到集合
            list.add("JavaSE");
        }

        System.out.println(list);

    }

    private static void method(List<String> list) {
        //解决方式一:循环遍历集合,判断集合是否包含JavaSE,如果没有包含就调用集合的add方法进行添加操作
        //定义一个标记
        boolean flag = false;
        //遍历集合
        for (String value : list) {
            //对遍历到的元素进行判断
            if(value.equals("JavaSE")){
                //更改标记的值
                flag = true;
                //结束循环
                break;
            }
        }

        //根据标记的状态决定是否要添加元素到集合
        if(!flag){
            //添加元素到集合
            list.add("JavaSE");
        }

        System.out.println(list);
    }
}
