/**
 * 
 */
package com.luv2code.springboot.thymeleaf.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.thymeleaf.demo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleaf.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}
	

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee employee = null;
		if(result.isPresent()) {
			employee = result.get();
		}
		else
		{
			throw new RuntimeException("Employee with Id not found : " + theId);
		}
		return employee;
	}

	@Override
	@Transactional
	public void save(Employee empoyee) {
		employeeRepository.save(empoyee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
