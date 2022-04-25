package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			//read json file and convert to Student POJO
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			System.out.println("Student FirstName : " + student.getFirstName());
			System.out.println("Student LastName : " + student.getLastName());
			System.out.println("Student Address(Street) : " + student.getAddress().getStreet());
			System.out.println("Student Address(City) : " + student.getAddress().getCity());
			System.out.println("Student Langauges : ");
			for (String lang : student.getLanguages()) {
				System.out.println(lang);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
