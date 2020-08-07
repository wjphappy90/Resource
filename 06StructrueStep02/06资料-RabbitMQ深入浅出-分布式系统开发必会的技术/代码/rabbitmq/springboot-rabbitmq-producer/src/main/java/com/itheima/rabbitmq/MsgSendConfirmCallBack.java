package com.itheima.rabbitmq;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * 消息确认与回退
 */
public class MsgSendConfirmCallBack implements RabbitTemplate.ConfirmCallback {
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("消息确认成功....");
        } else {
            //处理丢失的消息
            System.out.println("消息确认失败," + cause);
        }
    }
}