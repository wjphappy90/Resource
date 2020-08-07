package com.itheima.test09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 有一个用于记录程序运行次数的属性文件，运行次数保存在一个count属性中，当到达指定次数3次时，则提示:"程序使用次数已满，请续费"
 1. 开发思路：
 1). 判断属性文件是否存在，如果不存在则创建一个。
 2). 使用load()方法加载文件中所有的属性到Properties集合中。
 3). 取得count属性，如果count属性为null，则设置count属性为0。
 4). 将取得的字符串转成整型，并判断是否大于等于3次，大于3次则到期，退出。
 5). 小于3则输出运行次数，并加1。
 6). 将整数转成字符串后存到Properties集合中。
 7). 创建输出流，并用store方法保存到文件中。
 */
public class Test09 {
    public static void main(String[] args) throws Exception {
        //创建Properties集合
        Properties prop = new Properties();
        //创建属性文件的对象
        File file = new File("day14_homework/copyright.properties");
        //1. 判断属性文件是否存在，如果不存在先创建。
        if (!file.exists()) {
            file.createNewFile();
        }

        //2. 读取文件中所有的属性，load()加载到Properties中。
        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);
        fis.close();

        //3. 取得count属性，如果count属性为null，则设置count属性为1，并更新Properties集合。
        String str = prop.getProperty("count","0"); // "3"
        //4. 如果不为null，则转成整型，并判断是否大于3，大于3则到期，退出。
        int count = Integer.parseInt(str); // 2
        if (count >= 3) {
            System.out.println("程序使用次数已满，请续费");
        } else {
            //5. 小于3则输出次数，并加1。整数转成字符串后存到Properties集合中。
            count++; // 3
            System.out.println("程序运行了：" + count + "次");
            //更新属性
            prop.setProperty("count", String.valueOf(count));//1
            //6. 创建输出流，并用store方法保存到文件中。
            FileOutputStream fos = new FileOutputStream(file);
            prop.store(fos, "software run times");
            fos.close();
        }
    }
}
