package com.work.ggr.jms.model;

/**
 * @author : gr
 * @date : 2020/3/7 11:27
 */
public class Email {
	private String id;
	private String name;
	private String address;
	private String head;
	private String body;

	public Email() {
	}

	public Email(String id, String name, String address, String head, String body) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.head = head;
		this.body = body;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Email{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", head='" + head + '\'' +
				", body='" + body + '\'' +
				'}';
	}
}
