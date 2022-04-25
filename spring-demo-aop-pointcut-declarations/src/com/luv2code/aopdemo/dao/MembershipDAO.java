package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addSillyMember() {
		System.out.println(getClass() + " : Doing My DB Work : Adding an account");
		
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + " : Going to Sleep");
		
	}

}
