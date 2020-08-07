package com.itheima.io;

import java.io.FileInputStream;
import java.io.IOException;

//回顾jdk8之前释放资源的代码
public class JDK7 {

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            //1. 建立程序与文件的数据通道
            fileInputStream = new FileInputStream("F:/a.txt");
            //2. 创建字节数组缓冲区
            byte[] buf = new byte[1024];
            int length = 0 ;
            //3. 读取数据，并且输出
            while((length = fileInputStream.read(buf))!=-1){
                System.out.println(new String(buf,0,length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
