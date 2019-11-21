package com.work.ggr.dbsync.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @author : gr
 * @date : 2019/11/21 9:00
 */
@Configuration
public class DatabaseConfig {

    @Autowired
    Environment env;

    @Bean("mainDS")
    public DataSource initDS1() {
        System.out.println("init DataSource1");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setName("mainDS");
        return dataSource;
    }
    @Bean("backupDS")
    public DataSource initDS2(){
        System.out.println("init DataSource2");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url2"));
        dataSource.setUsername(env.getProperty("spring.datasource.username2"));
        dataSource.setPassword(env.getProperty("spring.datasource.password2"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name2"));
        dataSource.setName("backupDS");
        return dataSource;
    }

    
}
