package com.itheima.tree;

import org.junit.Test;

import java.text.SimpleDateFormat;

/**
 * 简单二叉查找树的测试
 */
public class SimpleBinartSearchTreeTest {
    
    @Test
    public void test1(){
        //创建容器
        SimpleBinarySearchTree tree = new SimpleBinarySearchTree();
        //向容器中添加值
        tree.put(2);
        tree.put(4);
        tree.put(6);
        tree.put(10);
        tree.put(15);
        tree.put(16);
        tree.put(17);
        tree.put(18);
        tree.put(5);
        tree.put(3);
        tree.put(9);
        tree.put(11);
        tree.put(12);
        // 从容器中取出节点值为12的节点
        SimpleBinarySearchTree.Node node = tree.find(12);
        System.out.println("节点值为12的节点为:"+node);
        tree.remove(12);
        node = tree.find(12);
        System.out.println("节点值为12的节点为:"+node);
        SimpleBinarySearchTree.Node max = tree.getMax();
        SimpleBinarySearchTree.Node min = tree.getMin();
        System.out.println("最大节点和最小节点:"+max.getValue()+"-----"+min.getValue());
    }
}
