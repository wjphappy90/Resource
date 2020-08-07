package com.itheima.thought;

import org.junit.Test;

/**
 * Created by tanshuai on 2019/9/15.
 */
public class DP {

   /* public int fib(int n){
        if(n <= 1 ){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }*/

    public static int fibonacci(int n){
        if(n<=0) {
            return -1;
        }
        //创建备忘录
        int [] memo=new int[n+1];
        for(int i=0;i<=n;i++){
            memo[i]=-1;
        }
        return fib(n, memo);
    }
    public static int fib(int n,int [] memo){
        //如果已经求出了fib（n）的值直接返回
        if(memo[n]!=-1) {
            return memo[n];
        }
        //否则将求出的值保存在memo备忘录中。               
        if(n<= 2){
            memo[n]=1;
        }else {
            memo[n]=fib( n-1,memo)+fib(n-2,memo);
        } 
        return memo[n];
    }

    /*public static int fib(int n){
        if(n<=0){
            return -1;   
        }
        //创建备忘录
        int [] memo=new int[n+1];
        memo[0]=0;
        memo[1]=1;
        //自底向上 先求解子问题 由子问题求解父问题
        for(int i=2;i<=n;i++){
            memo[i]=memo[i-1]+memo[i-2];
        }
        return memo[n];
    }*/
    
    public static int fib(int n)
    {
        if(n<=1) {
            return -1;
        }
        
        int memo_i_2=0;
        int memo_i_1=1;
        int memo_i=1;
        for(int i=2;i<=n;i++)
        {
            memo_i   = memo_i_2 + memo_i_1;
            memo_i_2 = memo_i_1;
            memo_i_1 = memo_i;
        }
        return memo_i;
    }
    
    @Test
    public void test1(){
        System.out.println(fibonacci(10));
        System.out.println(fib(10));
    }


    /**
     * 钢条切割问题
     * @param p 钢条长度和价格对应表
     * @param n 钢条长度
     * @return
     */
    public static int cutSteelBar(int [] p,int n)
    {
        if(n==0){
            return 0;
        }
        int q=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++) {
            q=Math.max(q, p[i-1]+cutSteelBar(p, n-i));
        }
        return q;
    }

    /**
     * 钢条切割:备忘录实现
     * @param p
     * @return
     */
    public static int cutBydemo(int []p)
    {
        int []r=new int[p.length+1];
        for(int i=0;i<=p.length;i++)
            r[i]=-1;
        return cut(p, p.length, r);
    }
    public static int cut(int []p,int n,int []r)
    {
        int q=-1;
        if(r[n]>=0)
            return r[n];
        if(n==0)
            q=0;
        else {
            for(int i=1;i<=n;i++)
                q=Math.max(q, cut(p, n-i,r)+p[i-1]);
        }
        r[n]=q;

        return q;
    }

    /**
     * 钢条切割:自底向上实现
     * @param p
     * @return
     */
    public static int buttom2up_cut(int []p)
    {
        int []r=new int[p.length+1];
        for(int i=1;i<=p.length;i++)
        {
            int q=-1;
            // 动态规划的核心
            for(int j=1;j<=i;j++)
                q=Math.max(q, p[j-1]+r[i-j]);
            r[i]=q;
        }
        return r[p.length];
    }

}
