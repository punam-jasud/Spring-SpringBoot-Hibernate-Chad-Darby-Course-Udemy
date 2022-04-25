package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			System.out.println("Create 3 Student");
			Student student1 = new Student("John", "Doe", "johndoe@gmail.com");
			Student student2 = new Student("Krishna", "Jadhav", "krishjadhav@gmail.com");
			Student student3 = new Student("vidya", "kardule", "vidyakardule@gmail.com");
			session.beginTransaction();
			System.out.println("Save Student");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
			factory.close();
		}

	}

}
