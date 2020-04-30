package com.work.ggr.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gr
 * 主要针对mq的消息中间键,屏蔽底层消息中间键的差异,降低切换成本,统一消息的编程模型
 *Spring Cloud Stream Applications are standalone executable applications that communicate over
 * messaging middleware such as Apache Kafka and RabbitMQ.
 */
@SpringBootApplication
public class SpringCloudStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamApplication.class, args);
    }

}
