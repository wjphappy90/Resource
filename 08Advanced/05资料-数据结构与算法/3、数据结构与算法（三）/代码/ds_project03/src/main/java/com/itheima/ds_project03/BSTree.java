package com.itheima.ds_project03;

import org.junit.Test;

import javax.xml.bind.ValidationEvent;
import java.util.EmptyStackException;

/**
 * 定义一个二叉查找树基础数据结构 【链表结构】
 */
public class BSTree {
    /**
     * 父节点
     */
    Node parent;

    /**
     * 删除二叉查找树中某个结点
                        * @param value
                        */
                public  void  delete(int value){
                    // 记录要删除的结点
                    Node p = parent;
                    // 记录要删除的结点的父节点
                    Node p_parent = null;
                    //  先找到要删除的元素及其父元素
                    while (p!=null){
                        if (p.value>value){
                            p_parent = p;
                p = p.left;
            }else  if(p.value <value){
                p_parent =p;
                p = p.right;
            }else {
                break;
            }
        }
        if (p == null){
            return;
        }
        // 要删除的结点有两个子节点
        if (p.left!=null && p.right!=null){
            Node rTree = p.right;
            Node rTree_p = p;   // rTree 父节点
            while (rTree.left!=null){
                rTree_p = rTree;
                rTree =rTree.left;
            }
            //  用右子树中的最小结点替换要删除的结点位置
            p.value = rTree.value;

            p = rTree;
            p_parent =rTree_p;
        }

        //  当我们要删除的结点时叶子结点或者只有一个叶子节点的结点

        Node child =null;

        if (p.right!=null){
             child = p.right;
        } else  if (p.left!=null){
             child =p.left;
        }else {
            child = null;
        }
        // 执行删除操作

        if(p_parent == null){
             parent = child;
        } else if (p_parent.left == p){
             p_parent.left =child;
        } else {
             p_parent.right =child;
        }
    }






    /**
     * 查找
     * @param value
     * @return
     */
    public  Node  find(int value){

        while (parent!=null){
            if (parent.value>value){
                parent = parent.left;
            } else  if (parent.value<value){
                parent = parent.right;
            } else {
                return  parent;
            }
        }
        return  parent;
    }

    /**
     * 向二叉查找树中插入
     */
    public boolean put(int value) {
        //  如果要插入的二叉查找树是一颗空树
        if (parent == null) {
            parent = createNode(value);
            return true;
        }
        Node pt = parent;
        while (pt != null) {
            //  当前我们要插入的数据 应该存储在左子树
            if (pt.value > value) {
                if (pt.left == null) {
                    pt.left = createNode(value);
                    return true;
                }
                pt = pt.left;
                //  当前我们要插入的数据应该存储在 右子树
            } else if (value > pt.value) {
                if (pt.right == null) {
                    pt.right = createNode(value);
                    return true;
                }
                pt = pt.right;

            }
        }
        return false;
    }


    /**
     * 构造一个没有左右子树树节点
     *
     * @param value
     * @return
     */
    private Node createNode(int value) {
        return new Node(null, value, null);
    }

    /**
     * 构造有左右子树的结点
     *
     * @param left
     * @param value
     * @param right
     * @return
     */
    private Node createNode(Node left, int value, Node right) {
        return new Node(left, value, right);
    }


    /**
     * 构建结点
     */
    private static class Node {
        // 定义我们值
        private int value;
        // 左子节点指针
        private Node left;
        // 右子节点指针
        private Node right;

        // 初始构造方法
        protected Node(Node left, int value, Node right) {
            this.left = left;
            this.value = value;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }


    public static void main(String[] args) {

        BSTree bsTree = new BSTree();
        bsTree.put(16);
        bsTree.put(14);
        bsTree.put(35);
        bsTree.put(12);
        bsTree.put(15);
        bsTree.put(25);
        bsTree.put(40);
        bsTree.put(10);
        bsTree.put(20);
        bsTree.put(27);
        bsTree.put(38);
        bsTree.put(41);
        bsTree.put(26);
        bsTree.put(30);
        bsTree.put(39);

//        Node node = bsTree.find(8);
//        System.out.println("值为8的结点信息："+node+"----"+node.value);

        bsTree.delete(10);

        System.out.println(bsTree);


    }



}
