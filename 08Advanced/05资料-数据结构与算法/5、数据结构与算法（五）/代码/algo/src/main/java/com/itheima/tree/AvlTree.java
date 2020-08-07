package com.itheima.tree;


/**
 * AVL树
 */
public class AvlTree<T extends Comparable> {

    // Avl树 根节点
    private AvlNode tree;

    /**
     * 插入数据
     * @param value
     */
    public void insert(T value){
        this.tree = insert(tree,value);
    }
    private AvlNode insert(AvlNode node,T data){
        // 将data添加到node节点的子节点上
        if(node == null){
            node = new AvlNode<T>(data);
        }else {
            int compared = data.compareTo(node.getData());
            if(compared > 0){
                // 要添加的值大于当前节点的值,将data存储到当前节点的右子树上 递归的插入
                node.right = insert(node.right,data);
                // 如插入后avl树变得不平衡,则应该重新调节该树的结构---旋转
                if(height(node.right) - height(node.left) == 2){
                    // 判断是RR还是RL
                    if(data.compareTo(node.right.getData()) > 0){ // 证明是RR
                        node = rightRotate(node);
                    }else { // 证明是RL
                        node = rightLeftRotate(node);
                    }
                }
                
            }else if(compared < 0){
                // 要添加的值小于当前节点的值,将data存储到当前节点的左子树上 递归的插入
                node.left = insert(node.left,data);
                // 如插入后avl树变得不平衡,则应该重新调节该树的结构---旋转
                if(height(node.left) - height(node.right) ==2){
                    //判断是LL还是LR
                    if(data.compareTo(node.left.getData()) > 0){ //证明是LR
                        node = leftRightRotate(node);
                    }else { // 证明是LL
                        node = leftRotate(node);
                    }
                }
            }else {
                //要添加的值和该节点的值相同，不做处理
            }
        }
        // 计算节点node的高度
        node.height = getMax(height(node.left),height(node.right)) + 1;
        return node;
    }
    
    /**
     * RL旋转
     * @param node 失衡节点
     * @return     旋转后根节点
     */
    public AvlNode rightLeftRotate(AvlNode node){
        // RL旋转可以拆分成一次LL旋转和一次RR旋转来完成
        node.right = leftRotate(node.right);
        return rightRotate(node);
    }

    /**
     * LR旋转
     * @param node  失衡节点
     * @return      旋转后根节点
     */
    public AvlNode leftRightRotate(AvlNode node){
        // 通过分析我们知道LR旋转可以拆分为一次RR旋转和一次LL旋转来完成
        node.left = rightRotate(node.left);
        return leftRotate(node);
    }

    /**
     * RR旋转
     * @param node  失衡节点
     * @return      右旋后的根节点
     */
    public AvlNode rightRotate(AvlNode node){
        // 定义临时变量保存右旋后的根节点 也就是失衡节点的右子树
        AvlNode new_root = node.right;
        // 将新的根节点的左子树当作失衡节点的右子树
        node.right = new_root.left;
        // 将失衡节点当作新的根节点的左子树
        new_root.left = node;
        // 重新计算失衡节点和新的根节点的高度
        node.height = getMax(height(node.left),height(node.right)) + 1;
        new_root.height = getMax(height(new_root.left),height(new_root.right)) +1;
        return new_root;
    }
    
    /**
     * LL旋转
     * @param node   失衡节点
     * @return       左旋后的根节点
     */
    public AvlNode leftRotate(AvlNode node){
        // 定义临时变量保存 失衡节点的左子树 该节点也是左旋后的根节点
        AvlNode node_left = node.left;
        // 将失衡节点左子树的右子树作为失衡节点的左子树
        node.left = node_left.right;
        // 将失衡节点作为旋转后根节点的右子树
        node_left.right = node;
        // 重新计算失衡节点和旋转后根节点的高度
        node.height = getMax(height(node.left),height(node.right)) + 1;
        node_left.height = getMax(height(node_left.left),height(node_left.right)) +1;
        return node_left;
    } 
    
    
    /**
     * 获取某一节点的高度
     * @param node
     * @return
     */
    private int height(AvlNode node) {
        return node == null ? 0:node.height;
    }

    /**
     * 获取avl树的高度
     * @return
     */
    public int height() {
        return height(tree);
    }

    /**
     * 返回两个高度中的最大值
     * @param height1
     * @param height2
     * @return
     */
    private int getMax(int height1,int height2){
        return height1 > height2 ? height1:height2;
    }

    /**
     * toString方法我们使用中序遍历的方式打印树
     * @return
     */
    @Override
    public String toString() {
        System.out.println("前序遍历的结果:");
        preOrder(tree);
        System.out.println("\n");
        System.out.println("中序遍历的结果:");
        inOrder(tree);
        System.out.println("\n");
        System.out.println("后续编辑的结果:");
        postOrder(tree);
        return "";
    }

    /**
     * 中序遍历
     *  先打印左子树
     *  然后打印自身
     *  最后打印右子树
     * @param node
     */
    public void inOrder(AvlNode node){
        if(node == null ){
            return;
        }
        inOrder(node.left);
        System.out.print(node.getData()+"->");
        inOrder(node.right);
    }

    /**
     * 前序遍历
     *  先打印自身
     *  然后打印左子树
     *  最后打印右子树
     * @param node
     */
    public void preOrder(AvlNode node){
        if(node == null){
            return;
        }
        System.out.print(node.getData()+"->");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 后续遍历
     *   先打印左子树
     *   然后打印右子树
     *   最后打印自身
     * @param node
     */
    public void postOrder(AvlNode node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.getData()+"->");
    }

    /**
     * AVL树的节点
     */
    public static class AvlNode<T extends Comparable>{
        // 节点中存储的数据
        private T data;
        // 左子树节点
        private AvlNode<T> left;
        // 右子树节点
        private AvlNode<T> right;
        // 节点的高度
        private int height;
        
        protected AvlNode(T data,AvlNode left,AvlNode right,int height){
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = height;
        }
        protected AvlNode(T data,AvlNode left,AvlNode right){
            this(data,left,right,0);
        }
        
        protected AvlNode(T data){
            this(data,null,null);
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public AvlNode getLeft() {
            return left;
        }

        public void setLeft(AvlNode left) {
            this.left = left;
        }

        public AvlNode getRight() {
            return right;
        }

        public void setRight(AvlNode right) {
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

