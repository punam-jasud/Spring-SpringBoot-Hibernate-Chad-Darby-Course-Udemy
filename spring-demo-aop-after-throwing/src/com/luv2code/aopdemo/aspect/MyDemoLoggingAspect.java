package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	
	// add after returning advice
	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "ex")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,Throwable ex) {

		String methodSignature = joinPoint.getSignature().toShortString();
		System.out.println("\n============>Executing @AfterThrowing on Method : " + methodSignature);

		System.out.println("\n============>The Exception is : " + ex);

		
	}
	
	
	// add after returning advice
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

		String methodSignature = joinPoint.getSignature().toShortString();
		System.out.println("\n============>Executing @AfterReturning on Method : " + methodSignature);

		System.out.println("\n============>Result is : " + result);

		// Modify Result - add/remove/update/delete
		// convert account name to uppercase
		convertAccountNamesToUpperCase(result);

		System.out.println("\n============>Result is : " + result);

	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for(Account account : result) {
			String upperName = account.getName().toUpperCase();
			account.setName(upperName);
		}
	}


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
