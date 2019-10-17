package com.work.ggr.config;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivitiConfig {
	/*
	 *1. act_hi_ 历史数据表，hi是history的缩写，对应HistoryService接口
	  1. act_re_ 流程存储表，re是repository的缩写，对应RepositoryService接口，存储流程部署和流程定义等静态数据
	  1. act_ru_ 运行时数据表，ru是runtime的缩写，对应RuntimeService接口和TaskService接口，存储流程实例和用户任务等动态数据
 
	 */

	@Bean
	public ProcessEngine intiEngine() {
		ProcessEngineConfiguration engineConfiguration = ProcessEngineConfiguration
				.createStandaloneProcessEngineConfiguration();
		engineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
		engineConfiguration.setJdbcUrl(
				"jdbc:mysql://192.168.0.127:3306/activiti_test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
		engineConfiguration.setJdbcUsername("guirong");
		engineConfiguration.setJdbcPassword("guirong");

		engineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

		ProcessEngine engine = engineConfiguration.buildProcessEngine();
		System.out.println(engine);
		return engine;
	}
	
	@Bean
	public RepositoryService initRepositoryService(ProcessEngine engine) {
		RepositoryService repositoryService=engine.getRepositoryService();
		System.out.println("***********"+repositoryService);
		return repositoryService;
	}
	
	@Bean
	public RuntimeService initRuntimeService(ProcessEngine engine) {
		RuntimeService runtimeService=engine.getRuntimeService();
		System.out.println("***********"+runtimeService);
		return runtimeService;
	}
	@Bean
	public TaskService initTaskService(ProcessEngine engine) {
		TaskService taskService=engine.getTaskService();
		System.out.println("***********"+taskService);
		return taskService;
		
	}
}
