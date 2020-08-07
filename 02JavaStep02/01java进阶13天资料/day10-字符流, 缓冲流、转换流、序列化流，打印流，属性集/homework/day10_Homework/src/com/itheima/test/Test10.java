package com.itheima.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test
 * @date 2018/5/4  下午3:33
 */
public class Test10 {
    public static void main(String[] args) throws IOException {
        //创建集合
        ArrayList<String> list = new ArrayList<>();
        //读取关联文件
        BufferedReader br = new BufferedReader(new FileReader("day10_Homework/text.txt"));
        String line;
        while((line = br.readLine()) != null) {
            //每读取一行放入集合
            list.add(line);
        }
        //关闭流
        br.close();
        //反转集合
        Collections.reverse(list);
        //写入关联文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("day10_Homework/text1.txt"));
        for(int i = 0; i < list.size(); i++) {
            //逐行写入
            bw.write(list.get(i));
            bw.newLine();//换行
            bw.flush();//刷新
        }
        bw.close();//关闭流
    }

}
