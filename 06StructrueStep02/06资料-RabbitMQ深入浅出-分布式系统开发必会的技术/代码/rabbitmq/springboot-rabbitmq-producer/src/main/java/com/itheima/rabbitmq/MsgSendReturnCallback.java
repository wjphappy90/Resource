package com.itheima.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

//消息发送回调
public class MsgSendReturnCallback implements RabbitTemplate.ReturnCallback {
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        String msgJson  = new String(message.getBody());
        System.out.println("Returned Message："+msgJson);
    }
}