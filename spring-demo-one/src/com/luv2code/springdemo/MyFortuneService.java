package com.luv2code.springdemo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyFortuneService implements FortuneService {
	
	List<String> fortuneList = Arrays.asList("Random Fortune One","Random Fortune Two","Random Fortune Three");
	Random random = new Random();

	@Override
	public String getFortune() {
		return fortuneList.get(random.nextInt(fortuneList.size()));
	}

}
