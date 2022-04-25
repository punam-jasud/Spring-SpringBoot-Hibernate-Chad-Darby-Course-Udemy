package com.luv2code.springboot.demo.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;

	@GetMapping("/")
	public String sayHello() {
		return "Hello World!  " + "Time on a Server is " + LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a Hard 5k";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your Lucky Day";
	}
	
	@GetMapping("/teamInfo")
	public String getTeamInfo() {
		return "Coach : " + coachName + " ," + "Team : " + teamName;
	}
}
