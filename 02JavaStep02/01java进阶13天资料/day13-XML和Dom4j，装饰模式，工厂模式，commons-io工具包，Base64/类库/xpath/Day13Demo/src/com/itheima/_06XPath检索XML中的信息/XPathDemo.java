package com.itheima._06XPath检索XML中的信息;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
/**
    目标：XPath检索XML中的信息啊。

    引入：
        Dom4J可以用于解析整个XML的数据。
        但是如果要检索XML中的某些信息，建议使用XPath.
    XPath使用步骤：
        1.导入dom4j框架。（XPath依赖于Dom4j的）
        2.导入XPath独有的框架包。jaxen-1.1.2.jar
    XPath常用API:
        List<Node> selectNodes(String var1):检索出一批节点集合。
        Node selectSingleNode(String var1)：检索出一个节点返回。
 */
public class XPathDemo {
    private Document document;
    @Before
    public void before() throws Exception {
        //1. 得到SaxReader
        SAXReader reader = new SAXReader();
        //2. 得到文档对象
        document = reader.read(XPathDemo.class.getResourceAsStream("/Contacts.xml"));
    }

    // 1.绝对路径定位元素：/根元素/子元素/二级元素。
    @Test
    public void xpath01() throws Exception {
        //用绝对路径检索
        List<Node> nodes = document.selectNodes("/contactList/contact/name");
        for(Node node : nodes){
            System.out.println(node.getText());
        }
    }

    // 2.相对路径定位元素：./子元素/二级元素。(用处不算很大)
    @Test
    public void xpath02() throws Exception {
        // 通过绝对路径得到根节点：/contactList
        Node node = document.selectSingleNode("/contactList");
        // 相对于根节点继续检索: .是相对于当前根节点。
        List<Node> nodes = node.selectNodes("./contact/name");
        for(Node n : nodes){
            System.out.println(n.getText());
        }
    }

    // 3.全文检索
    //contact ： 在整个XML中检索contact元素。
    //contact/name：在整个XML中检索contact下的一级name元素。
    //contact//name：在整个XML中检索contact下的全部name元素。
    @Test
    public void xpath03() throws Exception {
        // List<Node> nodes = document.selectNodes("//contact");
        //List<Node> nodes = document.selectNodes("//contact/name");
        List<Node> nodes = document.selectNodes("//contact//name");
        for(Node node : nodes){
            System.out.println(node.getText());
        }
    }

    // 4.属性检索
    //@id  ： 在整个XML文件中检索id属性。
    //contact[@id] ： 在整个XML文件中检索全部contact中包含id属性。
    //contact[@id=2] ： 在整个XML文件中检索全部contact中的包含id属性，且id属性值为2的contact
    @Test
    public void xpath04() throws Exception {
//      List<Node> nodes = document.selectNodes("//@id");
//      for(Node node : nodes){
//            Attribute attr = (Attribute) node;
//            System.out.println(attr.getValue());
//      }

//      List<Node> nodes = document.selectNodes("//contact[@id]");
//      for(Node node : nodes){
//            System.out.println(node.getName());
//      }

        Node node = document.selectSingleNode("//contact[@id=2]");
        Element ele = (Element) node;
        System.out.println(ele.elementText("name"));
    }
}
