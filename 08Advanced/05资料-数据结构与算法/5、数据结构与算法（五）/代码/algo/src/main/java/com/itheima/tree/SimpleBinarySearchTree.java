package com.itheima.tree;

/**
 * 二叉搜索树
 */
public class SimpleBinarySearchTree {
    
    // 二叉查找树,指向根节点
    private Node tree;

    /**
     * 获取最小节点
     * @return
     */
    public Node getMin(){
        if(tree ==null){
            return null;
        }
        Node p = tree;
        while (p.left != null){
            p = p.left;
        }
        return p;
    }

    /**
     * 获取最大节点
     * @return
     */
    public Node getMax(){
        if(tree ==null){
            return null;
        }
        Node p = tree;
        while (p.right != null){
            p = p.right;
        }
        return p;
    }
    

    /**
     1：要删除的节点是叶子节点即没有子节点，我们只需将父节点中指向该节点的指针置为null即可，这是最简单的一种形式。比如删除图中的节点10

     2：要删除的节点只有一个子节点(只有左子节点或者只有右子节点)，我们只需要更新父节点中，指向要删除节点的指针，让它指向要删除节点的子节点就可以了。比如删除图中的节点38

     3：要删除的节点有两个子节点，这是最复杂的一种情况，我们需要找到这个节点的右子树中的最小节点，把它替换到要删除的节点上。然后再删除掉这个最小节点，因为最小节点肯定没有左子节点（如果有左子结点，那就不是最小节点了）

     * @param value
     */
    public void remove(int value){
        // 记录要删除的节点
        Node p = tree;
        // 记录要删除节点的父节点
        Node p_parent = null;
        //先找到要删除的元素及其父元素
        while (p != null ) {
            if(p.value > value){
                p_parent = p;
                p = p.left;
            }else if( p.value < value){
                p_parent = p;
                p = p.right;
            }else {
                break;
            }
        }
        //如果没有找到则返回
        if(p == null){
            return;
        }
        
        // 要删除的节点有两个子节点 这种情况要用右子树中最小节点的值替换当前要删除元素的值，然后删除右侧最小节点
        if(p.left!=null && p.right !=null){
            // 找到该节点右子树的最小节点----->最左侧的叶子节点
            Node rigthTree = p.right;
            Node rightTree_p = p; // rigthTree的父节点
            while(rigthTree.left !=null){
                rightTree_p = rigthTree;
                rigthTree = rigthTree.left;
            }
            // 用右子树中最小的节点替换当前要删除的节点
            p.value = rigthTree.value;
            // 删除右子树中最小的节点，考虑到删除操作的其他两种情况：要删除元素是叶子节点以及要删除元素只有一个子节点都属于元素的删除 这里
            // 思路和逻辑都是一样的，为统一代码逻辑编写在此处不直接删除
            p = rigthTree;
            p_parent = rightTree_p;
        }
        
        // 删除节点是叶子节点或者仅有一个子节点,都是要删除该节点，将父节点的指针指向当前节点的子节点
        Node child = null;
        //计算当前节点的子节点
        if(p.right != null ){ // 当前元素的右子节点不为空
            child = p.right;
        }else if( p.left != null ){ // 当前元素的左子节点不为空
            child =  p.left;
        }else {
            child = null;
        }
        //执行删除
        if(p_parent == null ){ // 要删除根节点
            tree = child;
        }else if(p_parent.left == p) { //更新父节点的左指针
            p_parent.left = child;
        }else {
            p_parent.right = child;
        }
        
    }

    /**
     * 将value值存入容器
     * @param value
     * @return
     */
    public boolean put(int value){
        if(tree == null){
            tree = createNode(value);
            return true;
        }
        
        Node parent = tree;
        //遍历
        while (parent !=null){
            if(parent.value > value){
                if(parent.left ==null){
                    parent.left = createNode(value);
                    return true;
                }
                parent = parent.left;
            }else if(parent.value < value){
                if(parent.right ==null){
                    parent.right = createNode(value);
                    return true;
                }
                parent = parent.right;
            }
        }
        return false;
    }
    
    private Node createNode(Node left,int value,Node right){
        return new Node(left,value,right);
    }
    private Node createNode(int value){
        return createNode(null,value,null);
    }

    /**
     * 根据指定的值查找对应的节点
     * @param value
     * @return
     */
    public Node find(int value){
        Node parent = tree;
        
        while (parent !=null){
            
            if(parent.value > value){
                parent = parent.left;
            }else if(parent.value < value){
                parent = parent.right;
            }else {
                return parent;
            }
        }
        return parent;
    }
    
    
    public static class Node{
        private int value;
        private Node left;
        private Node right;
        
        protected Node(Node left,int value,Node right){
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
}
