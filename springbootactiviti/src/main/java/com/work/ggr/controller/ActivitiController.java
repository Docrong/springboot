package com.work.ggr.controller;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivitiController {

	@Autowired
	private ProcessEngine engine;

	@RequestMapping("/test")
	public String test() {
		System.out.println("engine is " + engine);
		return "test";
	}

	@RequestMapping("/deploy")
	public String deployFlow() {
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 得到任务服务组件
		TaskService taskService = engine.getTaskService();
		System.out.println(repositoryService);
		System.out.println(runtimeService);
		System.out.println(taskService);
		
		repositoryService.createDeployment()
		.name("请假申请流程")
		//部署流程描述文件
		.addClasspathResource("processes/MyFirstTask.bpmn")
		//部署流程图
		.addClasspathResource("processes/MyFirstTask.png")	
		.deploy();

		return "deployFlow";
	}
}
