package com.itcastbk02.test;

import com.itheimabk02.domain.OrderInfo;
import com.itheimabk02.service.OrderInfoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @version 1.0
 * @Author 周洪丙
 **/
public class AtomikosTest02 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext cat = new ClassPathXmlApplicationContext("spring.xml");
        OrderInfoService orderInfoService = cat.getBean(OrderInfoService.class);

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId((int) (Math.random()*1000));
        orderInfo.setAddress("顺义黑马训练营");
        orderInfo.setCreateTime(new Date());
        orderInfo.setUserid("zhangxiaoliu");
        orderInfo.setMoney(666d);
        orderInfoService.add(orderInfo);
    }
}
