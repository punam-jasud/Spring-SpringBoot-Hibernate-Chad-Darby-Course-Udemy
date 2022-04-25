package com.luv2code.springboot.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.demo.entity.Employee;


@Repository
public class EmployeeHibernateDAOImpl implements EmployeeDAO {
	
	private EntityManager entityMangager;
	
	@Autowired
	public EmployeeHibernateDAOImpl(EntityManager entityMangager) {
		this.entityMangager = entityMangager;
	}


	@Override
	public List<Employee> findAll() {

		Session currentSession = entityMangager.unwrap(Session.class);
		TypedQuery<Employee> q = currentSession.createQuery("from Employee", Employee.class);
		
		List<Employee> employees =  q.getResultList();

		return employees;
	}


	@Override
	public Employee findById(int theId) {
		Session currentSession = entityMangager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, theId);
		return employee;
	}


	@Override
	public void save(Employee empoyee) {
		Session currentSession = entityMangager.unwrap(Session.class);
		currentSession.saveOrUpdate(empoyee);
		
	}


	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityMangager.unwrap(Session.class);
		Query q = currentSession.createQuery("delete from Employee where id= :theId");
		q.setParameter("theId", theId);
		q.executeUpdate();
		
	}

}
