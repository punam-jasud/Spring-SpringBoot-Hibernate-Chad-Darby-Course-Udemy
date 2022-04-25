package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	public void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	public void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forAppFlow() {}
	
	@Before("forAppFlow()")
	public void beforeAdvice(JoinPoint joinPoint) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("========>In @Before Advice : Calling "+ method);
		
		Object[] args = joinPoint.getArgs();
		for(Object arg : args) {
			logger.info("=========>Argument : "+arg);
		}
	}
	
	@AfterReturning(pointcut = "forAppFlow()",returning = "result")
	public void afterReturningAdvice(JoinPoint joinPoint , Object result) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("========>In @@AfterReturning Advice : Calling "+ method);
		
		logger.info("Result : " + result);
	}
	
}
