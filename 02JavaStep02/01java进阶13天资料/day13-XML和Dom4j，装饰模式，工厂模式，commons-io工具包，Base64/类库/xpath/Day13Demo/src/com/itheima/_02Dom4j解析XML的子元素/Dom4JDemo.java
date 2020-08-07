package com.itheima._02Dom4j解析XML的子元素;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.InputStream;

/**
    目标：Dom4j解析XML的子元素
    Element元素的API:
        String getName():取元素的名称。
        List<Element> elements():获取当前元素下的全部子元素（一级）
        List<Element> elements(String name):获取当前元素下的指定名称的全部子元素（一级）
        Element element(String name):获取当前元素下的指定名称的某个子元素，默认取第一个（一级）

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
        // 6.获取根元素下的全部子元素 。
        //List<Element> elements = root.elements();
        // 7.根据名称取一批子元素返回。
        //List<Element> elements = root.elements("contact");
        //for(Element ele : elements){
        //    System.out.println("\t"+ele.getName());
        //}

        // 取根元素下的一个子元素，默认取第一个返回。
        Element ele = root.element("contact");
        System.out.println(ele);
        System.out.println(ele.attributeValue("id")); // 取当前元素的id属性值
    }
}
