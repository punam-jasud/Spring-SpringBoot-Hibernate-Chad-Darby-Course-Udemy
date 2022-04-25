package com.luv2code.springboot.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.demo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Employee> findAll() {
		
		Query q = entityManager.createQuery("from Employee");
		List<Employee> employees = q.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Employee employee = entityManager.find(Employee.class, theId);
		return employee;
	}

	@Override
	public void save(Employee employee) {

		Employee dbEmployee = entityManager.merge(employee);
		employee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int theId) {
		
		Query  q = entityManager.createQuery("delete from Employee where id= :theId");
		q.setParameter("theId", theId);
		q.executeUpdate();

	}

}
