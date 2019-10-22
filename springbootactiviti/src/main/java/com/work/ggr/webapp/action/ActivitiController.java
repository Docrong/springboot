package com.work.ggr.webapp.action;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

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
	
	@Autowired 
	private DataSource ds;

	@RequestMapping("/test")
	public String test() {
		System.out.println("engine is " + engine);
		return "test";
	}

	/**部署流程
	 *
	 */
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

		return "deployFlow success!";
	}
	
	/**
	 * 删除流程
	 * @return
	 */
	@RequestMapping("/destroy")
	public String destoryFlow(HttpServletRequest request,HttpServletResponse response) {
		RepositoryService repositoryService = engine.getRepositoryService();
		System.out.println(ds);
		String deployname=String.valueOf(request.getParameter("deployname"));
		if(deployname.equals(""))
			deployname="请假申请流程";
			
		String deployid="";
		Connection conn;
		try {
			conn = ds.getConnection();
			Statement state=conn.createStatement();
			ResultSet rs=state.executeQuery("select * from act_re_deployment where name_='"+deployname+"'");
			while (rs.next()) {
				deployid=rs.getString("id_");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(deployid);
		repositoryService.deleteDeployment(deployid);
		
		return "deployid is "+deployid;
	}
}
