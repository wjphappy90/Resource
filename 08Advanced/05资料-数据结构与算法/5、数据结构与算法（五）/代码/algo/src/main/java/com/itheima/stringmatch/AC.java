package com.itheima.stringmatch;

import javafx.scene.transform.Rotate;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * AC自动机实现
 */
public class AC {
    //根节点
    private Node root;
    
    public AC(){
        root = new Node('/');
    }

    /**
     * 在模式串trie树中匹配主串text并打印可匹配的模式串
     * @param text
     * @return
     */
    public boolean match(String text){
        int n = text.length();
        char[] text_arr = text.toCharArray();
        Node p = root;
        for (int i = 0; i < n; ++i) {
            int index = text_arr[i] - 32;
            while (p.children[index] == null && p != root) {
                p = p.fail; 
            }
            p = p.children[index];
            if (p == null) {
                p = root; // 如果没有匹配的，从 root 开始重新匹配
            }
            Node tmp = p;
            while (tmp != root) { // 打印出可以匹配的模式串
                if (tmp.isWord == true) {
                    int pos = i-tmp.length+1;
                    System.out.println(" 匹配起始下标 " + pos + "; 长度 " + tmp.length);
                }
                tmp = tmp.fail;
            }
        }
        return false;
    }
    
    
    
    

    /**
     * 初始化trie树fail指针
     *  fail指针的构建我们通过BFS来实现
     */
    private void initFailPoint(){
        // 构建队列
        Queue<Node> queue = new LinkedList();
        this.root.fail = null;
        queue.add(root);
        
        while ( !queue.isEmpty()){
            
            Node pFather = queue.poll();
            
            for(int i=0;i< 95;i++){
                Node current = pFather.children[i];
                if(current ==null){
                    continue;
                }
                
                if(pFather == this.root){
                    current.fail = this.root;
                }else {

                    Node pFatherFail = pFather.fail;
                    while (pFatherFail !=null){
                        Node child = pFatherFail.children[current.data - 32];
                        if(child != null){
                            current.fail = child;
                            break;
                        }
                        pFatherFail = pFatherFail.fail;
                    }
                    if(pFatherFail == null){
                        current.fail = this.root;
                    }
                }
                queue.add(current);
            }
        }
    }

    /**
     * 通过字符串集合构建trie树
     * @param strs
     */
    public void buildTrie(String... strs){
        //将字符串集合构建成trie树
        if(strs == null || strs.length ==0){
            return;
        }
        for (int i=0;i< strs.length;i++){
            insert(strs[i]);
        }
        //初始化失败指针
        initFailPoint();
    }
    /**
     * 将字符串插入到trie树
     * @param text
     */
    public void insert(String text){
        if(text==null || text.length() ==0){
            return;
        }
        char[] t_arr = text.toCharArray();
        Node parent = root;
        for(int i=0;i< t_arr.length;i++){
            // 计算下标
            int index = t_arr[i] -32;
            // 某节点子节点指针数组的该下标处没有子元素节点,则创建,否则共享
            if(parent.children[index] ==null){
                parent.children[index] = new Node(t_arr[i]);
            }

            parent = parent.children[index];
        }
        parent.isWord = true;//最后一个节点的标志位为true
        parent.length = text.length();
    }
    
    
    private class Node{
        // 节点存储的数据
        private char data;
        //该节点下的所有子节点指针
        private Node[] children = new Node[95];
        // 标志位,为true表明从根节点到该节点路径上的所有字符是一个单词,为false表明只是一个前缀
        private boolean isWord = false;
        
        //存储当前节点的失败指针
        private Node fail;
        // 当isWord为true时记录模式串的长度
        private int length;
        
        public Node(char data){
            this.data = data;
        }
    }
    
    
    
    @Test
    public void test(){
        AC ac = new AC();
        ac.buildTrie("abcd","edfh","abce","edff","acdef","acdeh","acdem");
        ac.match("xefasabcdfgadsedff");
    }
}
