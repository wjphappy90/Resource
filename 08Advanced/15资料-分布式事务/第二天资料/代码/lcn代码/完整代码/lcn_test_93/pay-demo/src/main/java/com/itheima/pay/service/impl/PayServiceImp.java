package com.itheima.pay.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import com.itheima.pay.client.FeignOrderClient;
import com.itheima.pay.mapper.PaytableMapper;
import com.itheima.pay.service.PayService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class PayServiceImp implements PayService {


    @Resource
    PaytableMapper paytableMapper;
    @Resource
    FeignOrderClient orderClient;

    @Override
    @TxTransaction(isStart = true)
    @Transactional
    public Integer updatePayTable(Integer id, Integer ispay) {
        int cnt = paytableMapper.update(id, ispay);
//        int i = 1 / 0;
        int orderCnt = orderClient.updateOrder();
        int i = 1 / 0;
        return cnt;
    }
}
