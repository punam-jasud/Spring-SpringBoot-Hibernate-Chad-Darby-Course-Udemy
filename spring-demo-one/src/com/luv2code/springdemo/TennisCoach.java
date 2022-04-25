package com.luv2code.springdemo;

public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkOut() {
		return "Pratice tennis hard";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

}
