package cn.itcast.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * 入门案例:
 *      1.引入依赖
 *      2.配置application.yml文件
 *      3.发送消息的话,定义一个通道接口,通过接口中内置的messagechannel
 *              springcloudstream中内置接口  Source
 *      4.@EnableBinding : 绑定对应通道
 *      5.发送消息的话,通过MessageChannel发送消息
 *          * 如果需要MessageChannel --> 通过绑定的内置接口获取
 */
@SpringBootApplication
public class ProducerApplication{
	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class);
	}
}
