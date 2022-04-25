package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			Course course = new Course("Java");
			
			session.save(course);
			System.out.println("Saved course: "+course);
			
			Student stud1 = new Student("Punam", "Jasud","punamjasud@gmail.com");
			Student stud2 = new Student("Krishna", "Jadhav","krishjadhav@gmail.com");
			
			course.addStudent(stud1);
			course.addStudent(stud2);
			
			System.out.println("Saving students...");
			session.save(stud1);
			session.save(stud2);
			System.out.println("Saved students: " + course.getStudents());
			
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
