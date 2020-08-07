package com.itheima.test01;

import java.io.File;
import java.io.IOException;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test01
 * @date 2018/5/4  上午10:43
 */
public class Test01_02 {
    public static void main(String[] args) throws IOException {
        // 创建文件对象：绝对路径
        File f = new File("c:/a.txt");
        // 如果文件不存在，则创建文件
        if(!f.exists()) {
            f.createNewFile();
        }
    }
}
