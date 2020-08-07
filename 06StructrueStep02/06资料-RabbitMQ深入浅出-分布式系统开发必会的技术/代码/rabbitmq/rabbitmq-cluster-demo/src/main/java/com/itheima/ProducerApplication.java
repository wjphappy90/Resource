package com.itheima;

import org.springframework.amqp.rabbit.transaction.RabbitTransactionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 生产者的启动类
 */
@SpringBootApplication
@ImportResource("classpath:/spring/spring-rabbitmq.xml")
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

}
