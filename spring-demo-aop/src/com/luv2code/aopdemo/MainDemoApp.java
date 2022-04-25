package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.Account;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO dao = context.getBean("accountDAO",AccountDAO.class);
		Account account = new Account();
		dao.addAccount(account,true);
		
		System.out.println("\nLet's call it again!");
		dao.addAccount(account,false);
		
		dao.doWork();
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		membershipDAO.addSillyMember();
		
		membershipDAO.goToSleep();
		
		context.close();
	}

}
