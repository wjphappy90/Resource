package com.itheima.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 分析HashMap源码
 */
public class HashMapSource {

    public static void main(String[] args) {
        
        //基于jdk1.7
        HashMap map = new HashMap();
        //存入数据
        map.put("itcast","good");
        map.put("itheima","every good");
        //获取数据
        map.get("itcast");
        //删除数据
        map.remove("itcast");
        int i=0,k,m;
        if(true){
            System.out.println("111");
        }else if((i=1)>0){
            System.out.println("22222");
        }else {
            System.out.println("333333");
        }
        System.out.println(i);
        System.out.println(tableSizeFor(64));
    }

    private static int roundUpToPowerOf2(int number) {
        // assert number >= 0 : "number must be non-negative";
        return number >= 1 << 30
                ? 1 << 30
                : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }
    
    
    @Test
    public void testHashTable(){
        Hashtable hashtable = new Hashtable();
        hashtable.put("itcast","good");
        hashtable.get("itcast");
        hashtable.remove("itcast");
        
    }
}
