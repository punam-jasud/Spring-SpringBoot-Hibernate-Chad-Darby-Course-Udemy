package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger logger = Logger.getLogger(AroundDemoApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService bean = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		logger.info("Main Program : AroundDemoApp");
		logger.info("Calling Fortune");
		
		String data = bean.getFortune();
		logger.info("My Fortune : "+data);
		
		logger.info("Finished");
		
		context.close();
	}

}
