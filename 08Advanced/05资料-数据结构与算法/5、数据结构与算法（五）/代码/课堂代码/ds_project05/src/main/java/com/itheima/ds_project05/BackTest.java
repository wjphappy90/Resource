package com.itheima.ds_project05;

import java.awt.*;

/**
 * 回溯思想-八皇后问题
 */
public class BackTest {


    /**
     * 皇后数组 ：  下标标识  行数    值 标识列数
     */
    private  int []  queen;


    /**
     * 求解8皇后问题
     */

    public  void  backMethod(int n){
        // 皇后数组初始化
        queen = new int[n];
        // 初始化皇后起点
        for (int i=0;i<queen.length;i++){
            queen[i] = -1;
        }
        //  从第一个皇后开始
        int k=0;
        while (true){
            // 第k个皇后要移动一个
            queen[k] +=1;
            //  判断是否应该回到上一行搜索
            if (queen[k]>=n){
                // 皇后越界，此行没有位置可以放置皇后
                    if(k>0){
                          queen[k] =-1;
                          k--;
                          continue;  // 跳出下面的判断
                    }else {
                        break;
                    }
            }

            if (!isMatch(k)){
                  k++;
                  if (k>=n){
                       for (int i =0; i<n; i++){
                           System.out.print(queen[i]+"");
                       }
                      System.out.println();
                       k--;
                  }
            }

        }
    }

    /**
     *   判断我们第k个皇后是否与之前之后的皇后冲突
     */

        public  boolean  isMatch( int k){

            for (int i = k-1;i>-1;i--){
                if (queen[k] == queen[i] || Math.abs(queen[k]-queen[i])==Math.abs(k-i)){
                    return  true;
                }
            }
            return false;
        }

    public static void main(String[] args) {
        BackTest backTest = new BackTest();
        backTest.backMethod(8);
    }


}
