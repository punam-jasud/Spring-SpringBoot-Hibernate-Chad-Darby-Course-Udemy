package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//	@Before("execution(public void addAccount())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n=========>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n=========>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("execution(public void add*())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n=========>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("execution(void add*())")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n=========>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("execution(* add*())")com.luv2code.aopdemo.dao.Account
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n=========>>> Executing @Before advice on addAccount()");
//	}
	
//	@Before("execution(* add*(com.luv2code.aopdemo.dao.Account))")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n=========>>> Executing @Before advice");
//	}
	
//	@Before("execution(* add*(com.luv2code.aopdemo.dao.Account,..))")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n=========>>> Executing @Before advice");
//	}
	
//	@Before("execution(* add*(..))")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n=========>>> Executing @Before advice");
//	}
	
//	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
//	public void beforeAddAccountAdvice() {
//		System.out.println("\n=========>>> Executing @Before advice");
//	}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//include package ..exclude setter and getter
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void forDAOPackageNoGetterSetter() {}
	
	@Before("forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=========>>> Executing @Before advice - Add Account");
	}
	
	@Before("forDAOPackageNoGetterSetter()")
	public void performAPIAnalyticsAdvice() {
		System.out.println("\n=========>>> Executing @Before advice - Performing Analysis");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
