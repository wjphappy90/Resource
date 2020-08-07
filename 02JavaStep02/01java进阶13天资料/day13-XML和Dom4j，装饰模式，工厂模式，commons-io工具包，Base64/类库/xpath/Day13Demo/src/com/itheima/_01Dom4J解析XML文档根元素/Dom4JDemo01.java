package com.itheima._01Dom4J解析XML文档根元素;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.InputStream;

/**
    目标：dom4j: 获取Document对象和根元素

    dom4j安装步骤：
        a.去dom4j官网下载dom4j的框架：都是一些jar包。
        b.把dom4j的核心jar包导入到当前项目中去。
        c.在项目中创建一个文件夹：lib
        d.将dom4j-2.1.1.jar文件复制到 lib 文件夹
        e.在jar文件上点右键，选择 Add as Library -> 点击OK
        f.在类中导包使用

    Document文档：
         Element getRootElement()：获取根元素。
    小结：
        请记住API。
 */
public class Dom4JDemo01 {
    public static void main(String[] args) throws Exception {
        // 需求：解析Contact.xml文件
        // 1.创建一个dom4j框架的解析对象:代表了整个dom4j框架。
        SAXReader saxReader = new SAXReader();

        // 2.读取xml文件成为一个Document文档对象。 domcument对象==xml文件对象
        // 把文件读成一个字节输入流， /代表去当前模块所在的类路径src下寻找文件。
        InputStream is = Dom4JDemo01.class
                .getResourceAsStream("/Contact.xml");
        // 读取字节输入流直接转换成一个文档对象：document
        //  public Document read(InputStream in)
        Document document = saxReader.read(is);

        // 3.直接获取文档对象的根元素
        Element root = document.getRootElement();
        // 4.输出根元素的名称。
        System.out.println(root.getName());

    }
}
