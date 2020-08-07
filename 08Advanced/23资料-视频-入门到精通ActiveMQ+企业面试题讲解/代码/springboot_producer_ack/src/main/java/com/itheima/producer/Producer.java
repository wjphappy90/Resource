package com.itheima.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务消息发送
 */
//@Component
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Value("${activemq.name}")
    private String name;

    /**
     * 定时发送消息
     */
    @Scheduled(fixedDelay = 3000)
    public void sendMessage(){
        jmsMessagingTemplate.convertAndSend(name,"定时消息.....");
    }

}
