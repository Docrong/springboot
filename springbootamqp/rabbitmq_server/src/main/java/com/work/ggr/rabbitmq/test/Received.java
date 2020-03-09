package com.work.ggr.rabbitmq.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;


/**
 * @author : gr
 * @date : 2020/3/8 11:39
 */
public class Received {
	private final static String QUEUE_NAME = "q_test_01";

	public static void main(String[] argv) throws Exception {

		// 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		// 从连接中创建通道
		Channel channel = connection.createChannel();
		// 声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

//		// 定义队列的消费者
//		QueueingConsumer
//
//		// 监听队列
//		channel.basicConsume(QUEUE_NAME, true, consumer);
//
//		// 获取消息
//		while (true) {
//			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//			String message = new String(delivery.getBody());
//			System.out.println(" [x] Received '" + message + "'");
//		}
	}

}
