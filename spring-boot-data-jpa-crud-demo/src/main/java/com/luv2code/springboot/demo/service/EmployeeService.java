package com.luv2code.springboot.demo.service;

import java.util.List;

import com.luv2code.springboot.demo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee empoyee);
	
	public void deleteById(int theId);

}
