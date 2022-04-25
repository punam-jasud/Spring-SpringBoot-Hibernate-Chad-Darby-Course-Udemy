package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.dao.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n=========>>> Executing @Before advice - Add Account");
		
		//Display Method Signature
		
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		System.out.println("Method : "+ methodSignature);
		
		//Display Method Args
		 Object[] args = joinPoint.getArgs();
		 
		 for(Object arg : args) {
			 System.out.println(arg);
			 if(arg instanceof Account) {
				 Account account = (Account) arg;
				 System.out.println("Account Name : "+account.getName());
				 System.out.println("Account Level : "+account.getLevel());
			 }
		 }
	}
	
}
