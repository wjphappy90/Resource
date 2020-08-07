package com.heima.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @Author dayuan
 */
@RestController
@SpringBootApplication
@RequestMapping
public class ReplyingKafkaTemplateTest {
    Logger logger = LoggerFactory.getLogger(ReplyingKafkaTemplateTest.class);

    private static final String topic = "topic0703";

    @Bean
    public ConcurrentMessageListenerContainer<String, String> repliesContainer(ConcurrentKafkaListenerContainerFactory<String, String> containerFactory) {
        ConcurrentMessageListenerContainer<String, String> repliesContainer = containerFactory.createContainer("replies");
        repliesContainer.getContainerProperties().setGroupId("repliesGroup");
        repliesContainer.setAutoStartup(false);
        return repliesContainer;
    }

    @Bean
    public ReplyingKafkaTemplate<String, String, String> replyingTemplate(ProducerFactory<String, String> pf, ConcurrentMessageListenerContainer<String, String> repliesContainer) {
        return new ReplyingKafkaTemplate(pf, repliesContainer);
    }

    @Bean
    public KafkaTemplate kafkaTemplate(ProducerFactory<String, String> pf) {
        return new KafkaTemplate(pf);
    }

    @Autowired
    private ReplyingKafkaTemplate template;


    @GetMapping("/rsend/{input}")
    @Transactional(rollbackFor = RuntimeException.class)
    public String send(@PathVariable String input) throws ExecutionException, InterruptedException {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, input);
        RequestReplyFuture<String, String, String> requestReplyFuture = template.sendAndReceive(record);
        ConsumerRecord<String, String> stringStringConsumerRecord = requestReplyFuture.get();
        logger.info(stringStringConsumerRecord.value());
        return stringStringConsumerRecord.value();
    }

}
