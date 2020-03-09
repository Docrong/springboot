package com.work.ggr.rabbitmq02;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitmqServer02Application {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqServer02Application.class, args);
	}

}
