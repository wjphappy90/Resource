package com.itheima.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 演示点对点模式- 消息消费者（第二种方案） -- 更加推荐
 */
public class PTP_Consumer2 {

    public static void main(String[] args) throws JMSException {
        //1.创建连接工厂
        ConnectionFactory factory
                 = new ActiveMQConnectionFactory("tcp://192.168.66.133:61616");

        //2.创建连接
        Connection connection = factory.createConnection();

        //3.打开连接
        connection.start();

        //4.创建session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //5.指定目标地址
        Queue queue = session.createQueue("queue01");

        //6.创建消息的消费者
        MessageConsumer consumer = session.createConsumer(queue);

        //7.设置消息监听器来接收消息
        consumer.setMessageListener(new MessageListener() {
            //处理消息
            @Override
            public void onMessage(Message message) {
                if(message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage)message;

                    try {
                        System.out.println("接收的消息（2）："+textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //注意：在监听器的模式下千万不要关闭连接，一旦关闭，消息无法接收
    }

}
