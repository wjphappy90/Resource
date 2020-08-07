package com.itheima.test02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Set;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test
 * @date 2018/5/4  下午3:33
 */
public class Test14 {
   public static void main(String[] args) throws Exception{
        //1：创建一个空的集合 
       Properties prop = new Properties();
       FileInputStream fis = new FileInputStream("day09_Homework/score.txt");
        // 2:读取数据到集合中 
       prop.load(fis);
       //3:遍历集合，获取到每一个key 
       Set<String> keys = prop.stringPropertyNames();
       //获取到每一个key
       for (String key : keys) {
           if ("lisi".equals(key)){
               prop.setProperty(key, "100");
           }
       }
       FileOutputStream fos = new FileOutputStream("day09_Homework/score.txt");
       //把集合中所有的信息 ，重新存储到文件中 
       prop.store(fos, null);
       fos.close();
   }
}

