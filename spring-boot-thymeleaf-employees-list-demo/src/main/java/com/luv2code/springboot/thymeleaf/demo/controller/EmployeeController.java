package com.luv2code.springboot.thymeleaf.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleaf.demo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private List<Employee> empList;
	
	@PostConstruct
	private void loadData() {
		empList = new ArrayList<Employee>();
		empList.add(new Employee(1,"Punam","Jasud","punam@gmail.com"));
		empList.add(new Employee(2,"Krishna","Jadhav","krishna@gmail.com"));
		empList.add(new Employee(3,"Rutuja","Ghule","rutuja@gmail.com"));
		empList.add(new Employee(4,"Snehal","Shinde","snehal@gmail.com"));
	}
	
	@GetMapping("/list")
	public String getEmployees(Model model) {
		model.addAttribute("employees", empList);
		return "employees";
	}

}
