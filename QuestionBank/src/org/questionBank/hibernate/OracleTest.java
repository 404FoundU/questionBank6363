package org.questionBank.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OracleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDetails usr = new UserDetails();
		usr.setUserId(2);
		usr.setUserName("Testy");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(usr);
		session.getTransaction().commit();
	}

}
