package com.work.ggr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 搭建基本环节,创建数据库springbootCache
 * 开启基于缓存的注解@EnableCaching
 */
@SpringBootApplication
@EnableCaching
public class SpringbootcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcacheApplication.class, args);
	}

}
