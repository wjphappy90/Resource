package com.itheima;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;
import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;
/*
 * 演示永久代内存溢出  java.lang.OutOfMemoryError: PermGen space
 * -XX:MaxPermSize=8m
 */
public class Demo01 extends ClassLoader {
    public static void main(String[] args) {
        int j = 0;
        try {
            Demo01 test = new Demo01();
            for (int i = 0; i < 20000; i++, j++) {
                ClassWriter cw = new ClassWriter(0);
                cw.visit(Opcodes.V1_6, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                byte[] code = cw.toByteArray();
                test.defineClass("Class" + i, code, 0, code.length);
            }
        } finally {
            System.out.println(j);
        }
    }
}
