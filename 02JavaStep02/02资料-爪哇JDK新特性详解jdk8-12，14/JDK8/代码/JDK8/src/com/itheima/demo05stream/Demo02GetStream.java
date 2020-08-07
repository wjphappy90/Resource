package com.itheima.demo05stream;

import java.util.*;
import java.util.stream.Stream;

public class Demo02GetStream {
    public static void main(String[] args) {
        // 方式1 : 根据Collection获取流
        // Collection接口中有一个默认的方法: default Stream<E> stream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        Map<String, String> map = new HashMap<>();
        Stream<String> stream3 = map.keySet().stream();
        Stream<String> stream4 = map.values().stream();
        Stream<Map.Entry<String, String>> stream5 = map.entrySet().stream();

        // 方式2 : Stream中的静态方法of获取流
        // static<T> Stream<T> of(T... values)
        Stream<String> stream6 = Stream.of("aa", "bb", "cc");

        String[] strs = {"aa", "bb", "cc"};
        Stream<String> stream7 = Stream.of(strs);

        // 基本数据类型的数组行不行?不行的,会将整个数组看做一个元素进行操作.
        int[] arr = {11, 22, 33};
        Stream<int[]> stream8 = Stream.of(arr);
    }
}
