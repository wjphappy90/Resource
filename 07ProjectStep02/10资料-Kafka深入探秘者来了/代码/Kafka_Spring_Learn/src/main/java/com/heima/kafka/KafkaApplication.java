package com.heima.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@SpringBootApplication
@RequestMapping
class KafkaApplication {
    private static final Logger logger = LoggerFactory.getLogger(KafkaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @RequestMapping("/index")
    public String index() {


        return "Hello,Kafka!";
    }

    @Autowired
    private KafkaTemplate template;
    private static final String topic = "topic0703";

    /**
     * 发送消息 带事务
     */
    @GetMapping("/send/{input}")
    public String sendToKafka(@PathVariable String input) throws ExecutionException, InterruptedException {
        ListenableFuture<SendResult<Object, Object>> send = this.template.send(topic, input);
        //return "send success";

        // 带返回值的
        //SendResult<Object, Object> result = send.get();
        //return result.toString();

        // 事务操作
        template.executeInTransaction(t -> {
            t.send(topic, input);
            if ("error".equals(input)) {
                throw new RuntimeException("input is error");
            }
            t.send(topic, input + " anthor");
            return true;
        });
        return "send success";
    }

    @GetMapping("/sendt/{input}")
    @Transactional(rollbackFor = RuntimeException.class)
    public String sendToKafka2(@PathVariable String input) throws ExecutionException, InterruptedException {
        template.send(topic, input);
        if ("error".equals(input)) {
            throw new RuntimeException("input is error");
        }
        template.send(topic, input + " anthor");
        return "send success";
    }

    /**
     * 接收消息
     */
    @KafkaListener(id = "", topics = topic, groupId = "group.demo")
    public void listener(String input) {
        logger.info("input value：{}", input);
    }
}
