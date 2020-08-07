package com.itheima.ds_project03;

public class AVLTree {

    private  AVLNode tree;

    /**
     * 获取某一个结点的高度
     *
     */
    private int height(AVLNode  node){

        return  node==null?0:node.height;
    }
    /**
     * 获取树的高度
     */
    private int height(){
        return height(tree);
    }

    /**
     * 返回高度的最大值
     */
    private  int getMaxHeight(int height1,int height2){
        return  height1>height2? height1:height2;
    }

    @Override
    public String toString() {
            inOrder(tree);
        return "AVLTree{}";
    }

    /**
     * 中序遍历
     * 先打印左子树
     * 然后打印自身
     * 最后打印右子树
     * @param node
     */
    public void inOrder(AVLNode node){
        if(node == null ){
            return;
        }
        inOrder(node.left);
        System.out.print(node.getData()+"->");
        inOrder(node.right);
    }
    /**
     * 前序遍历
     * 先打印自身
     * 然后打印左子树
     * 最后打印右子树
     * @param node
     */
    public void preOrder(AVLNode node){
        if(node == null){
            return;
        }
        System.out.print(node.getData()+"->");
        preOrder(node.left);
        preOrder(node.right);
    }
    /**
     * 后续遍历
     * 先打印左子树
     * 然后打印右子树
     * 最后打印自身
     * @param node
     */
    public void postOrder(AVLNode node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.getData()+"->");
    }

    /**
     *   AVL 树结点定义
     * @param <T>
     */
    public static  class  AVLNode<T extends  Comparable>{
        // 结点数据
        private T data;
        // 左孩子
        private  AVLNode<T> left;
        // 右孩子
        private AVLNode<T> right;
        // 树的高度
        private  int height;

        public AVLNode(T data, AVLNode<T> left, AVLNode<T> right, int height) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = height;
        }

        public AVLNode(T data, AVLNode<T> left, AVLNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.height=0;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public AVLNode<T> getLeft() {
            return left;
        }

        public void setLeft(AVLNode<T> left) {
            this.left = left;
        }

        public AVLNode<T> getRight() {
            return right;
        }

        public void setRight(AVLNode<T> right) {
            this.right = right;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
