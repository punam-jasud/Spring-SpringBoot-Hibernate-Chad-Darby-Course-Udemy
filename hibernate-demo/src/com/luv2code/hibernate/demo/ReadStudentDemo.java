package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Create Student");
			Student student = new Student("Om","Dhavale","omdhavale@gmail.com");
			session.beginTransaction();
			System.out.println("Save Student");
			System.out.println(student);
			session.save(student);
			session.getTransaction().commit();
			
			//Read Student
			System.out.println("Saved Student Genertaed ID : "+ student.getId());
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting student with Id : "+student.getId());
			Student stud = session.get(Student.class,student.getId());
			
			System.out.println("Get Complete : "+stud);
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}

	}

}
