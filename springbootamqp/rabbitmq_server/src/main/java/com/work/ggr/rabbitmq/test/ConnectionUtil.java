package com.work.ggr.rabbitmq.test;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

/**
 * @author : gr
 * @date : 2020/3/8 11:33
 */
public class ConnectionUtil {
	public static Connection getConnection() throws Exception {
		//定义连接工厂
		ConnectionFactory factory = new ConnectionFactory();
		//设置服务地址
		factory.setHost("192.168.202.134");
		//端口
		factory.setPort(15672);
		//设置账号信息，用户名、密码、vhost
		factory.setVirtualHost("testhost");
		factory.setUsername("admin");
		factory.setPassword("admin");
		// 通过工程获取连接
		Connection connection = factory.newConnection();
		return connection;
	}

}
