package com.itheima.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 消息发送
     */
    @Test
    public void queueTest(){
        //路由键与队列同名
        rabbitTemplate.convertAndSend("itheima", "测试镜像队列消息发送111111");
    }


    /**
     * HA测试
     */
    @Test
    public void testHA(){
        for (int i=0; i<1; i++) //效果不明显可以加大发送的数据,发送的时候一定要盯着HA
        {
            rabbitTemplate.convertAndSend("item_topic_exchange",
                    "item.insert", "商品新增,路由Key为item.insert" +i);
        }
    }

}
