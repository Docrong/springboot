package com.work.ggr.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.amqp.core.Binding.DestinationType.QUEUE;

@SpringBootTest
class RabbitmqSeverApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	//关联关系
	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	void contextLoads() {
	}

	/*点对点消息
	 */
	@Test
	void p2pSend() {
		String exchange = "exchange.direct";
		String routingKey = "rabbit";
//		Message message=new Message();//需啊自己定义Message格式
//		rabbitTemplate.send(exchange,routingKey,message);

		Map map = new HashMap<>();
		map.put("id", "1");
		map.put("name", "张三");
		map.put("age", "12");
//将map转换为Message,并发送到RabbitMQ
		rabbitTemplate.convertAndSend(exchange, routingKey, map);
	}

	@Test
	void p2preceived() {
		Object o = rabbitTemplate.receiveAndConvert("rabbit");
		System.out.println(o.getClass());
		System.out.println(o);
	}

	@Test
	void funoutSend() {
		Map map = new HashMap<>();
		map.put("msg", "funoutSend");
		map.put("模式", "广播");
		rabbitTemplate.convertAndSend("exchange.fanout", "", map);
	}

	@Test
	void funoutReceived() {
		Object o = rabbitTemplate.receiveAndConvert("rabbit");
		System.out.println(o);
	}


	//创建一个直接exchange
	@Test
	void createExchange() {
		amqpAdmin.declareExchange(new DirectExchange("test-directExchange", true, false));
	}

	//创建队列
	@Test
	void createQueue() {
		amqpAdmin.declareQueue(new Queue("test-directQueue"));
	}

	//创建关联关系
	@Test
	void createBind() {
		amqpAdmin.declareBinding(new Binding("test-directQueue", QUEUE, "test-directExchange", "test-directQueue",
				new HashMap<>()));
	}

	@Test
	void testCreateData() {
		Map map = new HashMap();
		map.put("method", "testCreateData");
		map.put("date", new Date());
		rabbitTemplate.convertAndSend("test-directExchange","test-directQueue",map);
	}
}
