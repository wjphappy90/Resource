package com.itheima.stringmatch;

import org.junit.Test;

/**
 * KMP算法实现
 * https://www.bilibili.com/video/av3246487/
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/string/SubstringSearch.java
 */
public class KMP2 {


    /**
     * Slow method of pattern matching
     */
    public boolean hasSubstring(char[] text, char[] pattern){
        int i=0;
        int j=0;
        int k = 0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else{
                j=0;
                k++;
                i = k;
            }
        }
        if(j == pattern.length){
            return true;
        }
        return false;
    }

    /**
     * 计算next数组
     * 时间复复杂度O(m),m是模式串的长度
     */
    private int[] initNext(char pattern[]){
        int [] next = new int[pattern.length];
        int j =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[j]){
                next[i] = j + 1;
                j++;
                i++;
            }else{
                if(j != 0){
                    j = next[j-1];
                }else{
                    next[i] =0;
                    i++;
                }
            }
        }
        return next;
    }

    /**
     * KMP algorithm of pattern matching.
     */
    public int kmp(String t,String p){
        if (t == null || t.length() == 0 || p == null || p.length() == 0 || p.length() > t.length()) {
            return -1;
        }
        char[] t_array = t.toCharArray();
        char[] p_array = p.toCharArray();
        int n = t_array.length; // 主串长度
        int m = p_array.length;//  模式串长度
        
        int next[] = initNext(p_array);
        int i=0;
        int j=0;
        while(i < n && j < m){
            if(t_array[i] == p_array[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = next[j-1];
                }else{
                    i++;
                }
            }
        }
        if(j == m){
            return i -m;
        }
        return -1;
    }

    @Test
    public void test(){
        String a = "abcxabcdabcdabcy";
        String b = "xabc";
        System.out.println("匹配下标为:"+kmp(a,b));
    }
    
}
