package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			System.out.println("---------------------All Students :---------------- ");
			displayStudents(theStudents);
			
			System.out.println("---------------Students whose last name is Jadhav:-------------------");
			theStudents = session.createQuery("from Student s where s.lastName='Jadhav'").getResultList();
			displayStudents(theStudents);
			
			System.out.println("-------------------------Students whose last name is Jadhav OR first name is om:------------");
			theStudents = session.createQuery("from Student s where s.lastName='Jadhav' OR s.firstName='Om'").getResultList();
			displayStudents(theStudents);
			
			System.out.println("-------------------------Students whose email ends with luv2code.com------------");
			theStudents = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").getResultList();
			displayStudents(theStudents);
			
			
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student stud : theStudents) {
			System.out.println(stud);
		}
	}

}
