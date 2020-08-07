package com.itheima.order.service;

import com.codingapi.tx.annotation.TxTransaction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @Author 周洪丙
 **/
public interface OrderService {

    //定义接口
    int updateOrder();
}
