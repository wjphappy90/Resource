package com.itheima.service;

import com.itheima.domain.Product;

public interface ProductService {
    Product findByPid(Integer pid);
}