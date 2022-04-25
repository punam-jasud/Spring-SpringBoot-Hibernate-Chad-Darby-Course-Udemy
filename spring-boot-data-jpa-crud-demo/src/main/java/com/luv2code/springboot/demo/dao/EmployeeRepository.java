package com.luv2code.springboot.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luv2code.springboot.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
