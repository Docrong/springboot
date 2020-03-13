package com.work.ggr.jms.service;

import com.work.ggr.jms.model.Email;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author : gr
 * @date : 2020/3/7 11:37
 */
@Component
public class Receiver {

	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	public void receiveMessage(Email email) {
		System.out.println("Received <" + email.toString() + ">");
	}

}
