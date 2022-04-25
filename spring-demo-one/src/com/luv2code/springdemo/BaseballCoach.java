package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneServie;
	
	public BaseballCoach(FortuneService fortuneServie) {
		this.fortuneServie = fortuneServie;
	}

	@Override
	public String getDailyWorkOut() {
		return "Spend 30 minutes on batting pratice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneServie.getFortune();
	}
}
