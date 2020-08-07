package com.itheima.stream;

import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        testNullStream();
    }

//    - takeWhile() ：从Stream中依次获取满足条件的元素，直到不满足条件为止结束获取，只要遇到第一个不满足的条件元素马上停止获取
    public static void testTakeWhile(){
        //1.创建一个流
        Stream<Integer> stream = Stream.of(10, 20, 30, 40, 50, 7, 60);
        //2 筛选符合条件的元素  条件：num<50
        stream.takeWhile(num->num<50).forEach(num-> System.out.print(num+","));
    }

    //- dropWhile() ：  从Stream中依次删除满足条件的元素，直到不满足条件为止结束删除
     public static void testDropWhile(){
        //1.创建一个流
        Stream<Integer> stream = Stream.of(10, 20, 30, 40, 50, 7, 60);
        //2 删除符合条件的元素  条件：num<50
        stream.dropWhile(num->num<50).forEach(num-> System.out.print(num+",")); //结果：50， 7， 60
    }

    //- ofNullable() ： Java 8 中 Stream 不能完全为 null（一个元素不能为 null 多个元素是可以存在 null ），否则会报空指针异常。而 Java 9 中的 ofNullable 方法允许我们创建一个单元素 Stream，可以包含一个非空元素，也可 以创建一个空 Stream。
    public static void testNullStream() {
        Stream<Object> stream = Stream.ofNullable(null);
        System.out.println(stream.count());
    }
}
