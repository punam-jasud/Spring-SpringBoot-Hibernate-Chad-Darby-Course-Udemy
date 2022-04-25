package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Instructor.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);
			System.out.println("Instructor : " + instructor);
			
			if(instructor != null) {
				System.out.println("Deleting: " + instructor);
				session.delete(instructor); //will also delete instructor_detail object cz of cascade.all 
			}
			
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			factory.close();
		}

	}

}
