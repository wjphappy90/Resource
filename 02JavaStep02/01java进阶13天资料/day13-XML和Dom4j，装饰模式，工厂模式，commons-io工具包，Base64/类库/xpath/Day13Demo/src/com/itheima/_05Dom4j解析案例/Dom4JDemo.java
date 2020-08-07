package com.itheima._05Dom4j解析案例;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *  目标：Dom4j解析XML文件:Contacts.xml成为一个Java的对象（集合对象）
 */
public class Dom4JDemo {
    public static void main(String[] args) throws Exception {
        // 1.创建一个dom4j的解析对象
        SAXReader saxReader = new SAXReader();
        // 2.加载被解析的xml文件成为一个字节输入流
        InputStream is = Dom4JDemo.class.getResourceAsStream("/Contacts.xml");
        // 3.把字节输入流通过解析对象读成一个document文档对象
        Document document = saxReader.read(is);
        // 4.得到当前文档的根元素对象
        Element root = document.getRootElement();
        // 5.获取当前根元素下的全部子元素对象
        List<Element> elements = root.elements();
        // 6.创建一个集合存储每个子元素对象的内容
        List<Contact> contacts = new ArrayList<>();
        // 7.遍历3个子元素
        for(Element ele : elements){
            // 8.每个子元素都必须创建一个联系人对象封装它的数据。
            Contact contact = new Contact();
            contact.setId(Integer.valueOf(ele.attributeValue("id")));
            contact.setVip(Boolean.valueOf(ele.attributeValue("vip")));
            contact.setEmail(ele.elementTextTrim("email"));
            contact.setName(ele.elementTextTrim("name"));
            contact.setGender(ele.elementTextTrim("gender"));
            contacts.add(contact); // 把元素对象的数据加入到集合中去存储
        }
        // 9.输出集合对象即可
        System.out.println(contacts);
    }
}
