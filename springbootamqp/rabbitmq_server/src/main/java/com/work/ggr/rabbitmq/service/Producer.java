package com.work.ggr.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : gr
 * @date : 2020/3/9 19:39
 */
@RestController
public class Producer {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@RequestMapping("/send")
	public String  p2pSend() {
		String exchange="exchange.direct";
		String routingKey="grRabbit";
//		Message message=new Message();//需啊自己定义Message格式
//		rabbitTemplate.send(exchange,routingKey,message);

		Map map = new HashMap<>();
		map.put("id", "1");
		map.put("name", "张三");
		map.put("age", "12");

		rabbitTemplate.convertAndSend("exchange.direct","rabbit",map);
//		rabbitTemplate.convertAndSend("exchange.topic","*.news",map);
		return "o.toString()";
	}
}
