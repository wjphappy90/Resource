package com.heima.arrayTest;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * 面试题六:
 *      已知成员变量集合存储N多用户名称,在多线程的环境下,使用迭代器在读取集合数据的
 *      同时如何保证还可以正常的写入数据到集合?
 */
public class Test05 {
    public static void main(String[] args) {
        //创建线程任务
        CollectionThread ct = new CollectionThread();

        //开启10条线程
        for (int i = 0; i < 10; i++) {
            new Thread(ct).start();
        }
    }
}
