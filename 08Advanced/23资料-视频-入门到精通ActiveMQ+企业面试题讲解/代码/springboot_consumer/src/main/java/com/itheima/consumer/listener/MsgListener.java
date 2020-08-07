package com.itheima.consumer.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * 用于监听消息类（既可以用于队列的监听，也可以用于主题监听）
 */
@Component // 放入IOC容器
public class MsgListener {

    /**
     * 用于接收消息的方法
     *  destination: 队列的名称或主题的名称
     */
    @JmsListener(destination = "${activemq.name}")
    public void receiveMessage(Message message){
        if(message instanceof TextMessage){
            TextMessage textMessage = (TextMessage)message;
            try {
                System.out.println("接收消息："+textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
    }

}
