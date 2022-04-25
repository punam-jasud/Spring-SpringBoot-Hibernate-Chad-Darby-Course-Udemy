package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.Account;
import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO dao = context.getBean("accountDAO",AccountDAO.class);
		
		//call findAccounts method
		 List<Account> accounts = dao.findAccounts(false);
		
		 //display accounts
		 System.out.println("\nMain Program : AfterReturningDemoApp");
		 System.out.println("-------");
		 
		 System.out.println(accounts);
		 
		 System.out.println("\n");
		
		context.close();
	}

}
