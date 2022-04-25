package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		return "Run a Hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public void doMyStartUpStuff() {
		System.out.println("TrackCoach : inside method doMyStartUpStuff");
	}
	
	public void doMyCleanUpStuff() {
		System.out.println("TrackCoach : inside method doMyCleanUpStuff");
	}
}
