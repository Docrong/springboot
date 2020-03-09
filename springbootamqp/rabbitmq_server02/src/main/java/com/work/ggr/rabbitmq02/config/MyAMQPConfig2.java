package com.work.ggr.rabbitmq02.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : gr
 * @date : 2020/3/9 20:51
 */
@Configuration
public class MyAMQPConfig2 {
	@Bean
	public MessageConverter getMessageConverter(){
		return new Jackson2JsonMessageConverter();
	}
}
