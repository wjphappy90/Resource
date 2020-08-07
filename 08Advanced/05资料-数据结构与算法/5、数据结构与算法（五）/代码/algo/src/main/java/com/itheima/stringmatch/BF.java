package com.itheima.stringmatch;

import org.junit.Test;

/**
 * BF算法实现
 */
public class BF {

    /**
     * 使用bf算法在主串t中匹配模式串p
     * @param t   主串/目标串
     * @param p   模式串/字串
     * @return    能匹配上则返回p在t中匹配的下标,匹配不上则返回-1
     */
    public int bf(String t,String p){
        if(t==null|| t.length()==0|| p==null|| p.length()==0|| p.length()> t.length()){
            return -1;
        }
        // 将单一字符串转换成数组
        char[] t_array = t.toCharArray();
        char[] p_array = p.toCharArray();

        return match(t_array,p_array);
    }
    private int match(char[] t,char[] p){
        int i =0;// 主串下标
        int j=0;// 模式串下标
        int posi =0;//匹配到的位置
        
        while(i< t.length && j < p.length){
            
            if(t[i] == p[j]){ //如果匹配则目标串和模式串进行下一个字符的匹配
                i++;
                j++;
            }else {//如果匹配不成功，则从目标字符串的下一个位置开始从新匹配
                i = i-j+1;
                j=0;
            }
        }
        if(i<=t.length){
            posi = i-p.length;
        }else {
            posi = -1;
        }
        return posi;
    }
    /*private int match(char[] t,char[] p){
        
        for(int i=0;i<t.length-p.length+1;i++){
            boolean isMatch = true;
            for(int j=0 ;j < p.length;j++){
                
                if(p[j] != t[j+i]){
                    isMatch = false;
                    break;
                }
            }
            if(isMatch){
                return i;
            }else {
                continue;
            }
        }
        return -1;
    }*/
    
    
    @Test
    public void test(){
        String a = "abccbadef";
        String b = "cba";
        System.out.println("匹配下标为:"+bf(a,b));
    }
}
