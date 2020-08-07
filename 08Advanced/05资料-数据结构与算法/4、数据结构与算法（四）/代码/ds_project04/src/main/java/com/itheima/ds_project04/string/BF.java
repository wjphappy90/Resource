package com.itheima.ds_project04.string;


import sun.util.resources.hr.CalendarData_hr;

import java.lang.annotation.ElementType;

/**
 * 字符串匹配算法 BF 算法
 */
public class BF {
    /**
     *    使用bf算法在主串t中匹配子串p
     * @param t    主串
     * @param p   子串
     * @return
     */
    public  int  bf(String t,String p){
        if (t.length()==0|| t==null||p.length()==0||p==null|| t.length()<p.length()){
            return  -1;
        }
          //  将字符串转成字符数组

        char []  t_array = t.toCharArray();
        char [] p_array =p.toCharArray();

        //  匹配过程
        return  match(t_array,p_array);

        }

        private   int  match(char [] t, char [] p){
             int i =0 ;  // 主串的角标
             int j=0 ;  // 子串的角标
             int posi = 0;  // 找到位置
             while (i<t.length&&j<p.length){

                 if (t[i] == p[j]){
                     j++;
                     i++;
                 }else {
                     i=i-j+1;
                     j=0;
                 }

             }
             if (i<=t.length){
                 posi =i-p.length;
             }else {
                 posi = -1;
             }

        return posi;
        }

    public static void main(String[] args) {

        BF bf = new BF();
        int bf1 = bf.bf("abcd", "cd");
        System.out.println(bf1);

    }




}
