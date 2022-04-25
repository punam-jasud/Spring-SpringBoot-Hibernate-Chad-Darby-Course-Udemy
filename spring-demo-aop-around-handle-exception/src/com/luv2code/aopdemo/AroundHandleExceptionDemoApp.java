package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService bean = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		logger.info("Main Program : AroundHandleExceptionDemoApp");
		logger.info("Calling Fortune");
		boolean flag = true;
		String data = bean.getFortune(flag);
		logger.info("My Fortune : "+data);
		
		logger.info("Finished");
		
		context.close();
	}

}
