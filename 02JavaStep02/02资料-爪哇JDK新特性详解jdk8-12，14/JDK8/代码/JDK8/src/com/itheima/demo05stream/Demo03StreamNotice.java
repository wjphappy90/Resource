package com.itheima.demo05stream;

import java.util.stream.Stream;

public class Demo03StreamNotice {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("aa", "bb", "cc");
        // 1. Stream只能操作一次
        // long count = stream.count();
        // long count2 = stream.count();

        // 2. Stream方法返回的是新的流
        // Stream<String> limit = stream.limit(1);
        // System.out.println("stream" + stream);
        // System.out.println("limit" + limit);

        // 3. Stream不调用终结方法，中间的操作不会执行
        stream.filter((s) -> {
            System.out.println(s);
            return true;
        }).count();
    }
}
