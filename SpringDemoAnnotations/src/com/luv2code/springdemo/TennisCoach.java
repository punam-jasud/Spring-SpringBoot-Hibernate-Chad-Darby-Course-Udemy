package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	public TennisCoach() {
		System.out.println("TennisCoach : inside default constructor");
	}

	@Override
	public String getDailyWorkout() {
		return "Pratice Your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println("TennisCoach : inside setFortuneService");
//		this.fortuneService = fortuneService;
//	}
	
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("TennisCoach : inside doMyStartUpStuff");
	}
	
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println("TennisCoach : inside doMyCleanUpStuff");
	}

	
}
