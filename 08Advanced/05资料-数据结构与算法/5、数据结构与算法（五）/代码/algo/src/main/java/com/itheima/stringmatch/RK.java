package com.itheima.stringmatch;

import org.junit.Test;

/**
 * RK算法实现
 */
public class RK {


    /**
     * 使用bf算法在主串t中匹配模式串p
     * @param t   主串/目标串
     * @param p   模式串/字串
     * @return    能匹配上则返回p在t中匹配的下标,匹配不上则返回-1
     */
    public int rk(String t,String p){
        if(t==null|| t.length()==0|| p==null|| p.length()==0|| p.length()> t.length()){
            return -1;
        }
        int pHash = hash(p,26,31,0,p.length());
        /*int tHash = hash(t,26,31,0,t.length());
        if(pHash == tHash && match(t,p,0)){
            return 0;
        }*/
        for(int i=0;i<t.length() - p.length()+1;i++){
            if(hash(t,26,31,i,p.length()) == pHash && match(t,p,i)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 求一个字符串的哈希值
     * @param str       字符串
     * @param R         对应的进制
     * @param K         将字符串映射到K的范围内
     * @param start     从str串的start位置开始
     * @param len       模式串的长度len
     * @return
     */
    private int hash(String str,int R,int K,int start,int len){
        int hash = 0;
        for(int i=start;i<start+len;i++){
            hash = (R * hash + str.charAt(i)) % K;
        }
        return hash % K;
    }

    /**
     * 当连个字符串的hash一样时则表明哈希冲突了,hash值一样两个串不一定一样,需要再依次比较一下。
     * @param t   主串
     * @param p   模式串
     * @param i   从主串下标为i的地方开始比较
     * @return
     */
    private boolean match(String t,String p,int i){
        for(int j=0;j<p.length();j++){
            if(p.charAt(j) != t.charAt(j+i)){
                return false;
            }
        }
        return true;
    }


    @Test
    public void test(){
        String a = "abcedfg";
        String b = "xyz";
        System.out.println("匹配下标为:"+rk(a,b));
    }
}
