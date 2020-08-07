package com.itheima.test01;

import java.io.File;
import java.io.IOException;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test01
 * @date 2018/5/4  上午10:43
 */
public class Test01_05 {
    public static void main(String[] args) throws IOException {
        // 创建文件对象
        File f = new File("c:/a.txt");
        // 删除文件
        f.delete();

        // 创建文件夹对象
        File dir = new File("c:/aaa");
        // 删除文件夹
        dir.delete();
    }
}
