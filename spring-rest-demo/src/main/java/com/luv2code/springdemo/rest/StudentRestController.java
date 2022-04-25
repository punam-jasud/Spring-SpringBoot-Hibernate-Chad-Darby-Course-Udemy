package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> list;
	
	//Define @PostConstruct to load student data only once 
	 @PostConstruct
	 public void loadData() {
		list = new ArrayList<>();
		list.add(new Student("Punam","Jasud"));
		list.add(new Student("Krishna","Jadhav"));
		list.add(new Student("Vidya","Sathe"));
	 }
	
	//End Point for getting all students
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return list;
	}
	

	//End Point for getting single student
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		
		if(studentId >= list.size() || studentId < 0) {
			throw new StudentNotFoundException("Student Id not found - " + studentId);
		}
		
		return list.get(studentId);
	}
	
}
