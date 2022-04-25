package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private static Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	// add around advice
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("====>Executing @Around on Method : "+method);
		
		long begin = System.currentTimeMillis();
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			logger.warning(e.getMessage());
			throw e;
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		logger.info("====>Duration: "+ duration/1000.0 + " seconds");
		
		return result;
	}

	// add after(finally) advice
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFindAccountsAdvice(JoinPoint joinPoint) {

		String methodSignature = joinPoint.getSignature().toShortString();
		logger.info("\n============>Executing @After (finally) on Method : " + methodSignature);

	}

	// add after returning advice
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

		String methodSignature = joinPoint.getSignature().toShortString();
		logger.info("\n============>Executing @AfterReturning on Method : " + methodSignature);

		logger.info("\n============>Original Result is : " + result);

		// Modify Result - add/remove/update/delete
		// convert account name to uppercase
		convertAccountNamesToUpperCase(result);

		logger.info("\n============>Modified Result is : " + result);

	}

	// add after returning advice
	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "ex")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable ex) {

		String methodSignature = joinPoint.getSignature().toShortString();
		logger.info("\n============>Executing @AfterThrowing on Method : " + methodSignature);

		logger.info("\n============>The Exception is : " + ex);

	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result) {
			String upperName = account.getName().toUpperCase();
			account.setName(upperName);
		}
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		logger.info("\n=========>>> Executing @Before advice - Add Account");

		// Display Method Signature

		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		logger.info("Method : " + methodSignature);

		// Display Method Args
		Object[] args = joinPoint.getArgs();

		for (Object arg : args) {
			logger.info(arg.toString());
			if (arg instanceof Account) {
				Account account = (Account) arg;
				logger.info("Account Name : " + account.getName());
				logger.info("Account Level : " + account.getLevel());
			}
		}
	}

}
