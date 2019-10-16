package com.work.ggr;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

public class ActivitiTest {

	@Test
	public void test() {
		System.out.println("test");
	}

	@Test
	public void initTable() {
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
		System.out.println(engine);
		Deployment deployment = engine.getRepositoryService().createDeployment()
				.addClasspathResource("test.BPMN").addClasspathResource("test.png").deploy();
		System.out.println(deployment.getId() + "--" + deployment.getName());
	}

	@Test
	public void delployFlow() {

	}

}
