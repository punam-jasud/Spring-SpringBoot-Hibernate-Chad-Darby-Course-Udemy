package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class GetCoursesForPunamDemo {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {

			session.beginTransaction();
			
			int theId = 10;
			Student krishna = session.get(Student.class, theId);
			System.out.println("Krishna : "+krishna);
			System.out.println("Courses: "+krishna.getCourses());
			
			System.out.println("Deleting student");
			session.delete(krishna);
			
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
