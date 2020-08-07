package com.itheima.ds_project05.dp;

import com.sun.org.apache.xml.internal.security.Init;

import java.awt.*;

/**
 * 钢管切割问题
 */
public class CutSteeBar {
    /**
     *
     * @param p  钢条长度和价格对应
     * @param n   钢条的长度
     * @return
     */
    public  static  int  cut( int [] p, int n){

        if (n==0){
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for (int i=1;i<=n;i++){
            q= Math.max(q,p[i-1]+cut(p,n-i));
        }

        return q;

    }
}
