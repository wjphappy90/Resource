package com.itheima.bitmap;

/**
 * Created by tanshuai on 2019/9/15.
 */
public class BitMap {
    
    // java中char类型占用2字节16bit位
    private char[] bytes;
    
    //数据范围
    private int kBitis;
    
    
    public BitMap(int kBitis){
        bytes = new char[kBitis];
        
        this.kBitis = kBitis;
    }
}
