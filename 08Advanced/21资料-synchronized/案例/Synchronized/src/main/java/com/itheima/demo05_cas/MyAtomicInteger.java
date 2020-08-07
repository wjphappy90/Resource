package com.itheima.demo05_cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

// 使用CAS自定义原子类
class MyAtomicInteger {
    private volatile int data; // 保存数据的变量
    // private static final Unsafe unsafe = Unsafe.getUnsafe(); // Caused by: java.lang.SecurityException: Unsafe
    private static final Unsafe unsafe;
    static final long valueOffset; // 对象中data数据的内存地址偏移量

    static {
        try {
            // Unsafe类没有暴露给普通应用程序使用,只能通过反射来操作
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new Error(e);
        }

        try {
            // data 属性在 MyAtomicInteger 对象中的偏移量，用于Unsafe直接访问该属性
            valueOffset = unsafe.objectFieldOffset(MyAtomicInteger.class.getDeclaredField("data"));
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }

    public void increment() {
        int oldValue;
        do {
            // 获取共享变量旧值
            oldValue = data;
            // 使用cas尝试修改data为旧值+1，如果期间旧值被别的线程改了，返回false, 接着循环重试
        } while (!unsafe.compareAndSwapInt(this, valueOffset, oldValue, oldValue + 1));
    }

    public void decrement() {
        int oldValue;
        do {
            // 获取共享变量旧值
            oldValue = data;
            // 使用cas尝试修改data为旧值+1，如果期间旧值被别的线程改了，返回false, 接着循环重试
        } while (!unsafe.compareAndSwapInt(this, valueOffset, oldValue, oldValue - 1));
    }

    public int get() {
        return data;
    }
}