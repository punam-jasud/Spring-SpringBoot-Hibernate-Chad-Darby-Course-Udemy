package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] data = {
			"Random Fortune One",
			"Random Fortune Two",
			"Random Fortune Three"
	};
	
	private Random random = new Random();

	@Override
	public String getFortune() {
		int index = random.nextInt(data.length);
		return data[index];
	}

}
