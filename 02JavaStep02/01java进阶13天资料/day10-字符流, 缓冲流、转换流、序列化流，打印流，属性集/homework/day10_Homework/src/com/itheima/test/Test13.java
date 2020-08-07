package com.itheima.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test
 * @date 2018/7/1  下午1:58
 */
public class Test13 {
    public static void main(String[] args){
        // 创建Map集合
        Map<Integer,String> map = new HashMap<>();
        try(
                // 创建字符缓冲输入流对象
                BufferedReader br = new BufferedReader(new FileReader("a.txt"));
                // 创建字符缓冲输出流对象
                BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));
        ){

            // 定义变量接收读取到的行数据
            String line = null;
            // 循环读取数据
            while((line = br.readLine()) != null) {
                if (line.trim().length() == 0) continue;
                // 获得行号数字
                Integer key = Integer.parseInt(line.substring(0,1));
                System.out.println(key);
                // 存储数据到map集合
                map.put(key,line);
            }
            System.out.println("------------");
            // 获得键值对个数
            int size = map.size();
            System.out.println(size);
            for (int key = 1; key <= size ; key++) {
                // 根据键获得对应的行数据
                String value = map.get(key);
                System.out.println(value);
                // 利用输出流将value输出到目标文件中
                bw.write(value);
                // 输出换行符
                bw.newLine();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
