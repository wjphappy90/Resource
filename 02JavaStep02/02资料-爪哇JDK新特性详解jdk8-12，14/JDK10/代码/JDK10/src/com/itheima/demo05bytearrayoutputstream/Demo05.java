package com.itheima.demo05bytearrayoutputstream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Demo05 {
    public static void main(String[] args) throws IOException {
        String str = "你好";

        // byte[] bytes = str.getBytes(); // 使用默认编码UTF-8将字符串转成字节数组
        byte[] bytes = str.getBytes(Charset.forName("GBK")); // 使用指定的GBK编码将字符串转成字节数组
        System.out.println(Arrays.toString(bytes));
        // UTF-8 [-28, -67, -96, -27, -91, -67]
        // GBK [-60, -29, -70, -61]

        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int b;
        while ((b = bais.read()) != -1) {
            baos.write(b);
        }

        // System.out.println(baos.toString()); // 使用默认的UTF-8编码将字节数组转成字符串
        System.out.println(baos.toString(Charset.forName("GBK"))); // 使用指定的gbk编码将字节数组转成字符串

        baos.close();
        bais.close();
    }
}
