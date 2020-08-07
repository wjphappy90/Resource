package com.itheimabk02.service.impl;

import com.itheimabk02.domain.LogInfo;
import com.itheimabk02.domain.OrderInfo;
import com.itheimabk02.logmapper.LogInfoMapper;
import com.itheimabk02.mapper.OrderInfoMapper;
import com.itheimabk02.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @version 1.0
 * @Author 周洪丙
 **/
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private  LogInfoMapper logInfoMapper;

    public int add(OrderInfo orderInfo) {


        //测试用例1:此处发生异常(不用测)

        //保存orderInfo到 order库中order_info表
        int i1 = orderInfoMapper.add(orderInfo);
        System.out.println("orderInfo表受影响行数"+i1);

        //测试用例2:此处发生异常,orderInfo已经保存到 order库中order_info表中,但是前面的保存要做要做回滚
//        System.out.println("发生异常:测试用例1...............................");
//        int i=10/0;
        //保存logInfo到log库中log_info表
        LogInfo logInfo = new LogInfo();
        logInfo.setId((int) (Math.random()*1000));
        logInfo.setCreateTime(new Date());
        logInfo.setContent(orderInfo.toString());
        int i2 = logInfoMapper.add(logInfo);

        System.out.println("loginfo表受影响行数"+i2);
        //测试用例3:此处发生异常,orderInfo已经保存到 order库中order_info表中,保存logInfo到log库中log_info表,但是前面的保存的orderinfo和loginfo要做要做回滚
        System.out.println("发生异常:测试用例2...............................");
        int i=10/0;
        return 0;
    }
}
