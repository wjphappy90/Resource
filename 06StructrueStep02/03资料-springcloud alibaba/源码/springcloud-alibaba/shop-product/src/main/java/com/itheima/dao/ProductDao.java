package com.itheima.dao;

import com.itheima.domain.Product;
import com.itheima.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}
