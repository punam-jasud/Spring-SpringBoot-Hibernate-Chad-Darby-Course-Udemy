package com.luv2code.springboot.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.demo.entity.Employee;
import com.luv2code.springboot.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{theId}")
	public Employee findById(@PathVariable int theId){
		Employee employee = employeeService.findById(theId);
		if(employee == null) {
			throw new RuntimeException("Employee not found with Id - " + theId);
		}
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee){
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee employee){
		employeeService.save(employee);
		return employee;
	}

	@DeleteMapping("/employees/{theId}")
	public String deleteById(@PathVariable int theId){
		Employee employee = employeeService.findById(theId);
		if(employee == null) {
			throw new RuntimeException("Employee not found with Id - " + theId);
		}
		employeeService.deleteById(theId);
		return "Deleted Employee with Id - " + theId;
	}
}
