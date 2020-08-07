package com.itheima.service;

/***
 *
 *
 ****/
public interface OrderInfoService {

    /***
     * 下单
     * @param usernumber    : 购买用户
     * @param id   ： 商品ID
     * @param count  ：购买数量
     * @return
     */
    int create(String usernumber, Integer id, Integer count);
}
