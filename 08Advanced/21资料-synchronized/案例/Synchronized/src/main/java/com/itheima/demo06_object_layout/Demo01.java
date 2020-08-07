package com.itheima.demo06_object_layout;

import org.openjdk.jol.info.ClassLayout;

public class Demo01 {
    public static void main(String[] args) {
        LockObj obj = new LockObj();

        obj.hashCode();
        System.out.println(obj.hashCode());
        System.out.println(Integer.toHexString(obj.hashCode()));

        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}
