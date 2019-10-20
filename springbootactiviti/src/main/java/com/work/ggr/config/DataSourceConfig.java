package com.work.ggr.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DataSourceConfig {

	 @Autowired
	    private Environment env;
	 
	@Bean(name = "mysqlDataSource")
    public DataSource getDataSource() {
        System.out.println("==== init DS1 ====");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setName("mysqlDataSource");
        return dataSource;
    }
}
