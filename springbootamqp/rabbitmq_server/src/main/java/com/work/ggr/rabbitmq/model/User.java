package com.work.ggr.rabbitmq.model;

/**
 * @author : gr
 * @date : 2020/3/9 19:22
 */
public class User {
	private String name;
	private String age;
	private String nickname;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
