package com.itheima.stringmatch;

import org.junit.Test;

/**
 * KMP算法的实现
 */
public class KMP {


    /**
     * 使用KMP算法在主串t中查找模式串p，返回其位置
     * @param t  目标字符串/主串
     * @param p  模式串
     * @return
     */
    public int kmp(String t,String p) {
        if (t == null || t.length() == 0 || p == null || p.length() == 0 || p.length() > t.length()) {
            return -1;
        }
        char[] t_array = t.toCharArray();
        char[] p_array = p.toCharArray();
        int n = t_array.length; // 主串长度
        int m = p_array.length;//  模式串长度
        //初始化失效函数
        int[] next = initNext(p_array,m);
        int j=0;
        for (int i = 0; i < n; ++i) {
            while (j > 0 && t_array[i] != p_array[j]) { 
                j = next[j - 1] + 1;
            }
            if (t_array[i] == p_array[j]) {
                ++j;
            }
            if (j == m) { // 找到匹配模式串的了
                return i - m + 1;
            }
        }
        return -1;
    }

    /**
     * 通过模式串初始化失效函数
     * @param p_array    模式串
     * @param m          模式串长度
     * @return
     */
    private static int[] initNext(char[] p_array, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i) {
            while (k != -1 && p_array[k + 1] != p_array[i]) {
                k = next[k];
            }
            if (p_array[k + 1] == p_array[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }


    @Test
    public void test(){
        String a = "abcedfg";
        String b = "bc";
        System.out.println("匹配下标为:"+kmp(a,b));
    }

}



