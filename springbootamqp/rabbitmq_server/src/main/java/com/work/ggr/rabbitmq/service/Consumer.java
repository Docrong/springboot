package com.work.ggr.rabbitmq.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author : gr
 * @date : 2020/3/8 11:30
 * 五种队列:
 * 简单模式:生产者将消息发送到队列，消费者从队列中获取消息
 * work模式:一个生产者、2个消费者。一个消息只能被一个消费者获取。
 * 发布-订阅模式:
 * 路由模式:
 * topic模式
 * 点对点;广播;topic模式(匹配模式)
 */
@Service
public class Consumer {
	@RabbitListener(queues = "rabbit")
	public void received (JSONObject json){
		System.out.println("service 01 println:"+json);
	}
}
