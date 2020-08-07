package com.itheima.test03;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test01
 * @date 2018/5/4  上午10:43
 */
public class Test03_03 {
    public static void main(String[] args) {
        File dir = inputFile();
        // 创建map集合
        Map<String,Integer> map = new HashMap<String, Integer>();
        getFileType(dir,map);
        // 遍历map
        for(Map.Entry<String,Integer> entry:map.entrySet()) {
            System.out.println(entry.getKey() + " 类型的文件有 " + entry.getValue() + " 个 ");
        }
    }

    public static void getFileType(File f,Map<String,Integer> map) {
        if(f.isDirectory()) {
            File files[] = f.listFiles();
            for (File file : files) {
                getFileType(file,map);
            }
        } else {
            // 获得文件名
            String fileName = f.getName(); // aaa.txt
            // 获得文件扩展名
            String key = fileName.substring(fileName.lastIndexOf(".") + 1); // txt
            // 判断map是否包含key
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1); // txt 2
            } else {
                map.put(key, 1); // txt  1
            }
        }
    }

    /*
     * 根据用户输入的路径字符串创建文件对象
     */
    private static File inputFile() {
        // 创建键盘输入对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件夹路径：");
        // 接收用户输入的路径
        String filePath = sc.nextLine();
        // 根据路径字符串创建文件对象
        File dir = new File(filePath);
        if(!dir.exists()) throw new RuntimeException("你输入的文件路径不存在！！！");
        // 判断是否是文件夹
        if(!dir.isDirectory()){
            throw new RuntimeException("输入的路径不是文件夹路径！！！");
        }
        return dir;
    }
}
