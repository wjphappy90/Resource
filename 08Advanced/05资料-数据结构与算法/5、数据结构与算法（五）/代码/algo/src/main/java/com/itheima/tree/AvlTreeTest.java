package com.itheima.tree;

import org.junit.Test;

/**
 * AVL树的测试
 */
public class AvlTreeTest {
    
    @Test
    public void test1(){
        AvlTree tree = new AvlTree();
        // 添加节点
        tree.insert(10);
        tree.insert(8);
        tree.insert(3);
        tree.insert(12);
        tree.insert(9);
        tree.insert(4);
        tree.insert(5);
        tree.insert(7);
        tree.insert(1);
        tree.insert(11);
        tree.insert(17);
        // 打印结果
        System.out.println(tree);
    }
}
