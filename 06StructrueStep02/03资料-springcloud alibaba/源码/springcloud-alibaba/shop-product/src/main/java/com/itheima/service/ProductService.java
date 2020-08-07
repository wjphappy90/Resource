package com.itheima.service;

import com.itheima.domain.Product;

public interface ProductService {

    //根据pid查询商品信息
    Product findByPid(Integer pid);

    //扣减库存
    void reduceInventory(Integer pid, Integer number);
}
