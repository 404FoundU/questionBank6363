package org.questionBank.hibernate;

import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
import org.questionBank.dao.CourseDataUtil;
import org.questionBank.dao.InvalidCourseException;

public class OracleTest {

	private static final Log log = LogFactory.getLog(OracleTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CourseDataUtil courseDAO = new CourseDataUtil();
		String courseNumber = "CSCI-6363";
		String courseName = "Agile Software Engineering";
		String title = "Agile";
		String deptName = "Computer Science";
		Integer credit = 3;
		try{
			courseDAO.createCourse(courseNumber, courseName, title, deptName, credit);
		}catch(InvalidCourseException ex){
			log.error("Invalid Course: " + ex.getMessage(), ex);
			log.debug(ex.getStackTrace());
		}catch(Exception ex){
			log.error("Reached Exception: " + ex.getMessage(), ex);
			log.debug(ex.getStackTrace());
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
