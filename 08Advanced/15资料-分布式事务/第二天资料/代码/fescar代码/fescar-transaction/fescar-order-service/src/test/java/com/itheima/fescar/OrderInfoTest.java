package com.itheima.fescar;

import com.itheima.service.OrderInfoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/***
 *
 *
 ****/
public class OrderInfoTest {

    /***
     * 业务测试
     */
    @Test
    public void testOrder() throws IOException {
        ApplicationContext act = new ClassPathXmlApplicationContext("spring/spring-dubbo.xml");
        OrderInfoService orderInfoService = act.getBean(OrderInfoService.class);
        orderInfoService.create("itheima",1, 1);

    }
}
