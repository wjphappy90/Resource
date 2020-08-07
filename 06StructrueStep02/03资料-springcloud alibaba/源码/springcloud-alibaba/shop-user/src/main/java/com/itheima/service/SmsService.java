package com.itheima.service;

import com.alibaba.fastjson.JSON;
import com.itheima.dao.UserDao;
import com.itheima.domain.Order;
import com.itheima.domain.User;
import com.itheima.utils.SmsUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service("shopSmsService")
//consumerGroup-消费者组名  topic-要消费的主题
@RocketMQMessageListener(
        consumerGroup = "shop-user", //消费者组名
        topic = "order-topic",//消费主题
        consumeMode = ConsumeMode.CONCURRENTLY,//消费模式,指定是否顺序消费 CONCURRENTLY(同步,默认) ORDERLY(顺序)
        messageModel = MessageModel.CLUSTERING//消息模式 BROADCASTING(广播)  CLUSTERING(集群,默认)
)
public class SmsService implements RocketMQListener<Order> {

    @Autowired
    private UserDao userDao;

    //消费逻辑
    @Override
    public void onMessage(Order message) {
        log.info("接收到了一个订单信息{},接下来就可以发送短信通知了", message);

        //根据uid 获取手机号
        User user = userDao.findById(message.getUid()).get();

        //生成验证码 1-9 6
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            builder.append(new Random().nextInt(9) + 1);
        }
        String smsCode = builder.toString();

        Param param = new Param(smsCode);

        try {
            //发送短信 {"code":"123456"}
            SmsUtil.sendSms(user.getTelephone(), "黑马旅游网", "SMS_170836451", JSON.toJSONString(param));
            log.info("短信发送成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class Param {
        private String code;
    }
}
