package com.itheima.pay.service.impl;

//import com.codingapi.tx.annotation.TxTransaction;
import com.itheima.pay.client.FeignOrderClient;
import com.itheima.pay.mapper.PaytableMapper;
import com.itheima.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class PayServiceImp implements PayService {
    /**
     *1.注入支付表的mapper
     *2. 远程调用订单表的服务,这里使用feign转化为本地服务
     *3.更新支付表   payMapper
     *4.更新订单表的服务
     *5.开启本地事务
     *6.整合lcn框架,实现分布式事务
     *  加入tc模块:
     *  加入lcn的jar包
     *  与tm通信,需要通讯模块
     *  接管数据源
     *  添加lcn注解开启分布式事务
     */

    @Autowired
    private PaytableMapper paytableMapper;

    @Autowired
    private FeignOrderClient orderClient;

    @Override
    @Transactional
 // lcn全局事务管理器的发起方法,想tm发起全局事务管理的请求
    public Integer updatePayTable(Integer id, Integer ispay) {
        Integer status;

        //更新paytable的数据
       status  = paytableMapper.update(id, ispay);
        System.out.println("更新paytable成功,受影响条数为:"+status+"条");
        //通过feign远程调用order-demo的保存订单的方法

        status=orderClient.updateOrder();
//测试用例: 此处出现异常,分布式系统两边的事务都回滚
//        int i=1/0;
        return status;
    }
}
