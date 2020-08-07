package com.itheima.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 演示SpringBoot与ActiveMQ整合- 消息生产者
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProducerApplication.class)
public class SpringBootProducer {

    //JmsMessagingTemplate: 用于工具类发送消息
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Value("${activemq.name}")
    private String name;

    @Test
    public void ptpSender(){
        /**
         * 参数一：队列的名称或主题名称
         * 参数二：消息内容
         */
        jmsMessagingTemplate.convertAndSend(name,"spring boot message--topic");

    }



}
