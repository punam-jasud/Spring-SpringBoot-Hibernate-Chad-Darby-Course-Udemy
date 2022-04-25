package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsBeanScopeDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach  theCoach = context.getBean("tennisCoach",Coach.class);
		
		Coach  theAlphaCoach = context.getBean("tennisCoach",Coach.class);
		
		boolean result = theCoach == theAlphaCoach;
		
		System.out.println("Pointing to the same object : "+result);
		System.out.println("Memory location for theCoach : "+theCoach);
		System.out.println("Memory location for theAlphaCoach : "+theAlphaCoach);
		
		context.close();

	}

}
