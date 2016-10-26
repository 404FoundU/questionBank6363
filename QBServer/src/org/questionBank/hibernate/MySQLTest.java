package org.questionBank.hibernate;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.questionBank.data.Course;

public class MySQLTest {

	private static final Logger log = LogManager.getLogger(MySQLTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Course course = new Course();
		String courseNumber = "CSCI-6363";
		String courseName = "Agile Software Engineering";
		String title = "Agile";
		String deptName = "Computer Science";
		Integer credit = 3;
		course.setCourseName(courseName);
		course.setCourseNumber(courseNumber);
		course.setTitle(title);
		course.setDeptName(deptName);
		course.setCredit(credit);
		
		log.info("Creating Course");

		session.beginTransaction();
		session.save(course);
		session.getTransaction().commit();
	}

}
