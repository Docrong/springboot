package com.work.ggr.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author : gr
 * @date : 2019/12/6 16:14
 */
@Aspect
@Service
public class AopAspect {
	@Pointcut("execution(public * com.work.ggr.service.AopService.*(..))")
	public void pointCut(){
		System.out.println("PointCut");
	}

	@Before("pointCut()")
	public void logStart(){
		System.out.println("开始运行....参数列表是:{}");
	}
	@After("pointCut()")
	public void logEnd(){
		System.out.println("结束......");
	}
	@AfterReturning("pointCut()")
	public void logReturn(){
		System.out.println("正常返回......运行结果是:{}");
	}
	@AfterThrowing("pointCut()")
	public void logException(){
		System.out.println("运行异常......异常信息是:{}");
	}
	@Around("pointCut()")
	public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("@Arount:执行目标方法之前...");
		Object obj = proceedingJoinPoint.proceed();//相当于开始调div地
		System.out.println("@Arount:执行目标方法之后...");
		return obj;
	}

}
