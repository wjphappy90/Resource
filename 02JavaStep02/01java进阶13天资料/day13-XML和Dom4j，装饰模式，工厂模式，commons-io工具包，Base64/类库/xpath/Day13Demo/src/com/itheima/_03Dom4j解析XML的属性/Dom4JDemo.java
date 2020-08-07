package com.itheima._03Dom4j解析XML的属性;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
    目标：Dom4j解析XML的属性;

    Element元素的API:
        List<Attribute> attributes(): 获取元素的全部属性对象。
        Attribute attribute(String name):根据名称获取某个元素的属性对象。
        String attributeValue(String var1)：直接获取某个元素的某个属性名称的值。
    Attribute对象的API:
        String getName(): 获取属性名称。
        String getValue:获取属性值。
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
        // 7.直接获取第一个元素的全部属性对象
        List<Attribute> attributes = oneEle.attributes();
        for(Attribute attr : attributes){
            System.out.println(attr.getName()+"==>"+attr.getValue());
        }
        // 8.根据名称获取某个元素的属性对象
        Attribute attr1 = oneEle.attribute("desc");
        System.out.println(attr1.getName()+"----->"+attr1.getValue());
        // 9.直接获取元素的属性值
        System.out.println(oneEle.attributeValue("id"));
        System.out.println(oneEle.attributeValue("desc"));
    }
}
