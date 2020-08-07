package com.itheima.test;

import com.itheima.model.Person;
import com.itheima.utils.ArrayUtils;

public class ModuleTest {

    public static void main(String[] args) {
        int[] arr= {10,19,50,3,2};
        int max = ArrayUtils.getMax(arr); //添加依赖： alt+enter
        System.out.println("最大值："+max);

        Person p  = new Person(110,"张三");

    }
}
