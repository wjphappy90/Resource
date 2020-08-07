package com.itheima.stringmatch;

import java.util.List;

/**
 * Trie树
 */
public class Trie {
    // 根节点 不存储实际字符
    private Node root = new Node('/');

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
    }

    /**
     * 在trie树中判断是否存储字符串text
     * @param text
     * @return
     */
    public boolean find(String text){
        if(text==null || text.length() ==0){
            return false;
        }
        char[] t_arr = text.toCharArray();
        Node p = root;
        for(int i=0;i<t_arr.length;i++){
            int index = t_arr[i] -32;
            if(p.children[index] == null){
                return false;
            }
            p = p.children[index];
        }
        if(p.isWord){ // 能够完全匹配
            return true;
        }
        return false; //不能完全匹配,text只是个前缀
    }

    /**
     *  从trie树中查找text前缀的所有字符数据
     * @param text
     * @return
     */
    /*public List<String> startWiths(String text){
        if(text==null || text.length() ==0){
            return null;
        }
        char[] t_arr = text.toCharArray();
        Node p = root;
        for(int i=0;i<t_arr.length;i++){
            int index = t_arr[i] -32;
            if(p.children[index] == null){
                return null;
            }
            p = p.children[index];
        }
        // 获取最后一个节点的所有
        Node[] children = p.children;
        for(int i=0;i<children.length;i++){
            
            
        }

        return null;
    }*/
    
    
    
    private class Node{
        // 节点存储的数据
        private char data;
        //该节点下的所有子节点指针
        private Node[] children = new Node[95];
        // 标志位,为true表明从根节点到该节点路径上的所有字符是一个单词,为false表明只是一个前缀
        private boolean isWord = false;
        public Node(char data){
            this.data = data;
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("code");
        trie.insert("cook");
        trie.insert("five");
        trie.insert("file");
        trie.insert("fat");
        
        String text = "cod";
        boolean cook = trie.find(text);
        System.out.println("trie树中是否存在"+text+":"+cook);
    }
}
