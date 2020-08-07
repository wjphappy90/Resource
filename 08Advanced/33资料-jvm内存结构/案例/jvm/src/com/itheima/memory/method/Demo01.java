package com.itheima.memory.method;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/*
    用来加载类的二进制字节码

    元空间，默认使用系统内存，一般跟物理内存有关，一般很难出现问题

    现在加一个参数，设置元空间内存，
    演示元空间内存溢出 java.lang.OutOfMemoryError: Metaspace
    -XX:MaxMetaspaceSize=8m
    设置大小，警用指针压缩
    -XX:MaxMetaspaceSize=10m -XX:-UseCompressedOops

    -XX:MaxMetaspaceSize=8m -XX:MaxMetaspaceSize=10m -XX:-UseCompressedOops
 */
public class Demo01 extends ClassLoader {
    public static void main(String[] args) {
        int count = 0;
        try {
            Demo01 d = new Demo01();
            for (int i = 0; i < 20000; i++, count++) {
                //作用：生成类的二进制字节码
                ClassWriter cw = new ClassWriter(i);
                //版本号，方法修饰符，类名，包名，父类，接口
                cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                byte[] code = cw.toByteArray();
                //执行类的加载
                d.defineClass("Class" + i, code, 0, code.length);
            }
        } finally {
            System.out.println(count);
        }
    }
}
