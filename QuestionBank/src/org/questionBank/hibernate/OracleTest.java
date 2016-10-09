package org.questionBank.hibernate;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.questionBank.dao.CourseDataUtil;
import org.questionBank.dao.InvalidCourseException;

public class OracleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CourseDataUtil courseDAO = new CourseDataUtil();
		String courseNumber = "CSCI-6363";
		String courseName = "Agile Software Engineering";
		String title = "Agile";
		String deptName = "Computer Science";
		BigDecimal credit = new BigDecimal(3);
		try{
			courseDAO.createCourse(courseNumber, courseName, title, deptName, credit);
		}catch(InvalidCourseException ex){
			System.out.println("Invalid Course: "+ex.getMessage());
			System.out.println(ex.getStackTrace());
		}catch(Exception ex){
			System.out.println("Reached Exception: " + ex.getMessage());
			System.out.println(ex.getStackTrace());
		}
//		UserDetails usr = new UserDetails();
//		usr.setUserId(2);
//		usr.setUserName("Testy");
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(usr);
//		session.getTransaction().commit();
	}

}
