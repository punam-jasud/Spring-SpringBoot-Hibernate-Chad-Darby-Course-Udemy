package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService bean = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("Main Program : AroundDemoApp");
		System.out.println("Calling Fortune");
		
		String data = bean.getFortune();
		System.out.println("My Fortune : "+data);
		
		System.out.println("Finished");
		
		context.close();
	}

}
