package com.itheima.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 过期队列消息
     * 投递到该队列的消息如果没有消费都将在6秒之后被删除
     */
    @Test
    public void ttlQueueTest(){
        //路由键与队列同名
        rabbitTemplate.convertAndSend("my_ttl_queue", "发送到过期队列my_ttl_queue，6秒内不消费则不能再被消费。");
    }

    /**
     * 过期消息
     * 该消息投递任何交换机或队列中的时候；如果到了过期时间则将从该队列中删除
     */
    @Test
    public void ttlMessageTest(){
        MessageProperties messageProperties = new MessageProperties();
        //设置消息的过期时间，3秒
        messageProperties.setExpiration("3000");

        Message message = new Message("测试过期消息，3秒钟过期".getBytes(), messageProperties);
        //路由键与队列同名
        rabbitTemplate.convertAndSend("my_ttl_queue", message);
    }


    /**
     * 过期消息投递到死信队列
     * 投递到一个正常的队列，但是该队列有设置过期时间，到过期时间之后消息会被投递到死信交换机（队列）
     */
    @Test
    public void dlxTTLMessageTest(){
        rabbitTemplate.convertAndSend(
                "my_normal_exchange",
                "my_ttl_dlx",
                "测试过期消息；6秒过期后会被投递到死信交换机2222");
    }


    /**
     * 消息长度超过2，会投递到死信队列中
     */
    @Test
    public void dlxMaxMessageTest(){
        rabbitTemplate.convertAndSend(
                "my_normal_exchange",
                "my_max_dlx",
                "发送消息4：消息长度超过2，会被投递到死信队列中！");
/*

        rabbitTemplate.convertAndSend(
                "my_normal_exchange",
                "my_max_dlx",
                "发送消息5：消息长度超过2，会被投递到死信队列中！");

        rabbitTemplate.convertAndSend(
                "my_normal_exchange",
                "my_max_dlx",
                "发送消息6：消息长度超过2，会被投递到死信队列中！");

*/

    }


    /**
     * 消息确认
     */
    @Test
    public void queueTest(){
        //路由键与队列同名
        rabbitTemplate.convertAndSend("spring_queue", "只发队列spring_queue的消息。");
    }


    @Test
    public void testFailQueueTest() throws InterruptedException {
        //exchange 正确,queue 错误 ,confirm被回调, ack=true; return被回调 replyText:NO_ROUTE
        rabbitTemplate.convertAndSend("test_fail_exchange", "", "测试消息发送失败进行确认应答。");
    }


    @Test
    //@Transactional //开启事务
    //@Rollback(false)//在测试的时候，需要手动的方式制定回滚的策略
    public void queueTest2(){
        //路由键与队列同名
        rabbitTemplate.convertAndSend("spring_queue", "只发队列spring_queue的消息--02222222222222222222。");
        //System.out.println("----------------dosoming:可以是数据库的操作，也可以是其他业务类型的操作---------------");
        //模拟业务处理失败
        //System.out.println(1/0);
        //rabbitTemplate.convertAndSend("spring_queue", "只发队列spring_queue的消息--02。");
    }

}
