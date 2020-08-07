package com.itheima.ds_project05.dp;

/**
 * 演示使用动态规划的思想来优化我们的斐波拉契数列求解问题。
 *  方式1：自顶向下备忘录法
 */
public class Fb {



    // 计算斐波拉契数列

    /**
     *
     * @param n   计算斐波拉契数列中的某个项
     * @param memory  表示就是我们备忘录
     * @return  返回的计算后某一项结果
     */
    public static int fib(int n, int[] memory ){
        //  用-1 备忘录中没有记录f(n)的值
        // 如果备忘录中记录了该值，直接返回
        if(memory[n]!=-1){
            return memory[n];
        }
        if (n<=2){
            memory[n]=1;
        }else {
            memory[n] = fib(n-1,memory)+fib(n-2,memory);
        }
            return memory[n];
    }

    public static int fibonaci(int n){
        // 数据不合法
        if (n<=0){
            return -1;
        }
        //  创建备忘录
        int [] memeory = new int[n+1];
        // 给备忘录赋值
        for (int i=0;i<=n;i++){
            memeory[i]=-1;
        }
        return  fib(n,memeory);
    }

    public static void main(String[] args) {
        int i = fibonaci(7);
        System.out.println(i);
    }

}
