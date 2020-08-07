package com.itheima.service.impl;

import com.itheima.dao.OrderDao;
import com.itheima.dao.TxLogDao;
import com.itheima.domain.Order;
import com.itheima.domain.TxLog;
import com.itheima.service.OrderService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class OrderServiceImpl4 {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private TxLogDao txLogDao;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    public void createOrderBefore(Order order) {

        String txId = UUID.randomUUID().toString();

        //发送半事务消息
        rocketMQTemplate.sendMessageInTransaction(
                "tx_producer_group",
                "tx_topic",
                MessageBuilder.withPayload(order).setHeader("txId", txId).build(),
                order
        );
    }

    @Transactional
    public void createOrder(String txId, Order order) {
        //保存订单
        orderDao.save(order);

        TxLog txLog = new TxLog();
        txLog.setTxId(txId);
        txLog.setDate(new Date());

        //记录事物日志
        txLogDao.save(txLog);
    }


}
