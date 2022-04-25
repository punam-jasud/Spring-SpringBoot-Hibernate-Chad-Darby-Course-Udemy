package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	
	public List<Account> findAccounts(){
		List<Account> account = new ArrayList<Account>();
		
		Account account1 = new Account("Krishna","Silver");
		Account account2 = new Account("Vidya","Platinum");
		account.add(account1);
		account.add(account2);
		
		return account;
	}
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + "Adding an account");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + " : Doing My DB Work");
		
		return false;
	}

	public String getName() {
		System.out.println(getClass() + " : getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " : setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " : getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " : setServiceCode()");
		this.serviceCode = serviceCode;
	}

}
