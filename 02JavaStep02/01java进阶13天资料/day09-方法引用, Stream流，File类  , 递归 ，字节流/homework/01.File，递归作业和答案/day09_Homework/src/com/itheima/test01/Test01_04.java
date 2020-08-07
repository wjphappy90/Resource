package com.itheima.test01;

import java.io.File;
import java.io.IOException;

/**
 * @author pkxing
 * @version 1.0
 * @Package com.itheima.test01
 * @date 2018/5/4  上午10:43
 */
public class Test01_04 {
    public static void main(String[] args) throws IOException {
        // 创建文件对象
        File f = new File("c:/ccc/bbb/aaa");
        // 创建多级文件夹
        f.mkdirs();
    }
}
