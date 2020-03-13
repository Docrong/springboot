package com.work.ggr.jms.service;

import com.work.ggr.jms.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : gr
 * @date : 2020/3/7 11:42
 */
@RestController
public class Sender {
	@Autowired
	private JmsTemplate jmsTemplate;

	/**
	 * 发送订阅
	 */
	@GetMapping("/email/send")
	public Email updateItem(Email item) {
		item=new Email("id", "name","地址","邮件","你好,这是一封邮件");
		jmsTemplate.convertAndSend("mailbox", item);
		System.out.println("发送");
		return item;
	}
}

