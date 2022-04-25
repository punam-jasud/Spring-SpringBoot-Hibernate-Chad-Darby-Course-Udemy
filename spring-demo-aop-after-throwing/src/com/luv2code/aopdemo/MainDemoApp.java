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
		account.setName("Punam");
		account.setLevel("Platinum");
		dao.addAccount(account,true);
		
		System.out.println("\nLet's call it again!");
		dao.addAccount(account,false);
		
		dao.doWork();
		
		//call getters and setters
		dao.setName("foobar");
		dao.setServiceCode("silver");
		dao.getName();
		dao.getServiceCode();
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		membershipDAO.addSillyMember();
		
		membershipDAO.goToSleep();
		
		context.close();
	}

}
