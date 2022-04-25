package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		
		try {
			
			int studentId = 1;
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			System.out.println("Get Student with ID : "+ studentId);
			Student student = session.get(Student.class, studentId);
			System.out.println("-----------------Deleting Student:---------------------------");
			session.delete(student);
			
			System.out.println("------------Delete student using query---------");
			session.createQuery("delete Student where id = 3").executeUpdate();
			session.getTransaction().commit();

			System.out.println("Done");
			
		} finally {
			factory.close();
		}

	}

}
