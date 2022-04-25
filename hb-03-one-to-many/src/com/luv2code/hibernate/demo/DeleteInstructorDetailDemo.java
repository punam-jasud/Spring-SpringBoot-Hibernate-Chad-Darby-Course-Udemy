package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Instructor.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId = 3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
			if(instructorDetail != null) {
				System.out.println("Instructor Detail: "+instructorDetail);
				System.out.println("Instructor: "+instructorDetail.getInstructor());
			}
			System.out.println("Deleting Instructor_Detail: "+instructorDetail);
			instructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(instructorDetail);
			session.getTransaction().commit();
			System.out.println("Done");
			
		}catch(Exception e) {
			e.printStackTrace();
		} 		
		finally {
			session.close();
			factory.close();
		}

	}

}
