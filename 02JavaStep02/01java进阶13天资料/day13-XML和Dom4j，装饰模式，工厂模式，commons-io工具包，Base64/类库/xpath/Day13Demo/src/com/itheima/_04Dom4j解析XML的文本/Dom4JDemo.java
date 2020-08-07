package com.itheima._04Dom4j解析XML的文本;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
    目标：Dom4j解析XML的文本;

    Element:
        String elementText(String name): 可以直接获取当前元素的子元素的文本内容
        String elementTextTrim(String name): 去前后空格,直接获取当前元素的子元素的文本内容
        String getText():直接获取当前元素的文本内容。
        String getTextTrim():去前后空格,直接获取当前元素的文本内容。
 */
public class Dom4JDemo {
    public static void main(String[] args) throws Exception {
        // 1.创建一个dom4j的解析对象
        SAXReader saxReader = new SAXReader();
        // 2.加载被解析的xml文件成为一个字节输入流
        InputStream is = Dom4JDemo.class.getResourceAsStream("/Contact.xml");
        // 3.把字节输入流通过解析对象读成一个document文档对象
        Document document = saxReader.read(is);
        // 4.得到当前文档的根元素对象
        Element root = document.getRootElement();
        // 5.输出根元素的名称
        System.out.println(root.getName());
        // 6.定位第一个子元素
        Element oneEle = root.element("contact");
        System.out.println(oneEle.getName());
        // 7.可以直接获取当前元素的子元素的文本内容
        System.out.println(oneEle.elementText("name"));
        System.out.println(oneEle.elementText("gender"));
        System.out.println(oneEle.elementText("email"));
        System.out.println(oneEle.elementTextTrim("email")); // 去前后空格
        // 8.先获取子元素对象，再获取文本对象内容
        Element emailEle = oneEle.element("email");
        System.out.println(emailEle.getText());
        System.out.println(emailEle.getTextTrim());// 去前后空格
    }
}
