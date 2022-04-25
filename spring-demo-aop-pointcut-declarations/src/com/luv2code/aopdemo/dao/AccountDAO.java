package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
//	public void addAccount(Account account) {
//		System.out.println(getClass() + " : Doing My DB Work : Adding an account");
//	}
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + " : Doing My DB Work : Adding an account");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + " : Doing My DB Work");
		
		return false;
	}

}
