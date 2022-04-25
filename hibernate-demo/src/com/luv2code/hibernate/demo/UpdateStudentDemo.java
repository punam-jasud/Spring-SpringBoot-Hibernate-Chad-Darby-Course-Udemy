package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		
		try {
			
			int studentId = 2;
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			System.out.println("Get Student with ID : "+ studentId);
			Student student = session.get(Student.class, studentId);
			System.out.println("-----------------Updating Student:---------------------------");
			student.setFirstName("Kuttuuuu");
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("------------Update email for all students---------");
			session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();
			session.getTransaction().commit();

			System.out.println("Done");
			
		} finally {
			factory.close();
		}

	}

}
