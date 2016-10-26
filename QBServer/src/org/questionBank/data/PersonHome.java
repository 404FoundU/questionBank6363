package org.questionBank.data;
// Generated Oct 9, 2016 11:50:10 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class Person.
 * @see org.questionBank.data.Person
 * @author Hibernate Tools
 */


@Service
@Transactional
public class PersonHome {

	private static final Log log = LogFactory.getLog(PersonHome.class);

	@PersistenceContext
	private EntityManager transactionManager;
	@Transactional
	public void persist(Person transientInstance) {
		log.debug("persisting Person instance");
		try {
			transactionManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	@Transactional
	public void remove(Person persistentInstance) {
		log.debug("removing Person instance");
		try {
			transactionManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}
	@Transactional
	public Person merge(Person detachedInstance) {
		log.debug("merging Person instance");
		try {
			Person result = transactionManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	@Transactional
	public Person findById(String id) {
		log.debug("getting Person instance with id: " + id);
		try {
			Person instance = transactionManager.find(Person.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	@Transactional
	public Person findByuserName(String userName) {
		log.debug("getting Person instance with id: " + userName);
		try {
			Person instance = transactionManager.find(Person.class, userName);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
