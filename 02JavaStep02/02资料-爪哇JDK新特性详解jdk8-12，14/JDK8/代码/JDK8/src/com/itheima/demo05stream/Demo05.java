package com.itheima.demo05stream;

import java.util.List;
import java.util.stream.Stream;

public class Demo05 {
    public static void main(String[] args) {
        // 第一个队伍
        List<String> one = List.of("迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子", "洪七公");
        // 第二个队伍
        List<String> two = List.of("古力娜扎", "张无忌", "张三丰", "赵丽颖", "张二狗", "张天爱", "张三");

        // 1.第一个队伍只要名字为3个字的成员姓名;
        // 2.第一个队伍筛选之后只要前3个人;
        Stream<String> streamA = one.stream()
                .filter(s -> s.length() == 3)
                .limit(3);
        // 3.第二个队伍只要姓张的成员姓名;
        // 4.第二个队伍筛选之后不要前2个人;
        Stream<String> streamB = two.stream()
                .filter(s -> s.startsWith("张"))
                .skip(2);

        // 5.将两个队伍合并为一个队伍;
        Stream<String> streamAB = Stream.concat(streamA, streamB);

        // 6.根据姓名创建`Person`对象;
        // 7.打印整个队伍的Person对象信息。
        streamAB.map(Person2::new).forEach(System.out::println);
    }
}
