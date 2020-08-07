package com.itheima.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 消息发送的业务类
 */
@Service
public class MessageService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Value("${activemq.name}")
    private String name;

    @Transactional // 对消息发送加入事务管理（同时也对JDBC数据库的事务生效）
    public void sendMessage(){
        for(int i=1;i<=10;i++) {
            //模拟异常
            /*if(i==4){
                int a = 10/0;
            }*/

            jmsMessagingTemplate.convertAndSend(name, "消息---"+i);
        }
    }

}
