package com.itheima.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.jms.ConnectionFactory;

/**
 * ActiveMQ配置类
 */
@Configuration
public class ActiveMQConfig {

    /**
     * 添加Jms事务管理器
     */
    @Bean
    public PlatformTransactionManager createTransactionManager(ConnectionFactory connectionFactory){
        return new JmsTransactionManager(connectionFactory);
    }

}
