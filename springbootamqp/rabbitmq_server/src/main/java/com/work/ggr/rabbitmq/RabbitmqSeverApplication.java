package com.work.ggr.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置类 RabbitAutoConfiguration:
 * 1. rabbitConnectionFactory   动配置rabbitmq的配置信息
 * 2. rabbitTemplate     rabbitmq发送和接收消息
 * 3. amqpAdmin     rabbitmq系统管理组件,创建和删除exchange,queue,bind关联关系
 * 4. rabbitMessagingTemplate
 * @author gr
 * //开启基于注解的rabbitmq
 */
@EnableRabbit
@SpringBootApplication
public class RabbitmqSeverApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqSeverApplication.class, args);
	}

}
