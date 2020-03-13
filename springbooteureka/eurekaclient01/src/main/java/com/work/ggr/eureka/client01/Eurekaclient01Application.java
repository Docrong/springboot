package com.work.ggr.eureka.client01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Eurekaclient01Application {

	public static void main(String[] args) {
		SpringApplication.run(Eurekaclient01Application.class, args);
	}

}
