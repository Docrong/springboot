package com.work.ggr.rabbitmq02.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author : gr
 * @date : 2020/3/9 20:39
 */
@Service
public class Consumer {
	@RabbitListener(queues = "rabbit")
	public void received (JSONObject json){
		System.out.println("service 02 println:"+json);
	}
}
