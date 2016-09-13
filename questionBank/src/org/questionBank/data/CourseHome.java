package org.questionBank.data;
// Generated Sep 13, 2016 2:54:40 AM by Hibernate Tools 5.1.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Course.
 * @see org.questionBank.data.Course
 * @author Hibernate Tools
 */
@Stateless
public class CourseHome {

	private static final Log log = LogFactory.getLog(CourseHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Course transientInstance) {
		log.debug("persisting Course instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Course persistentInstance) {
		log.debug("removing Course instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Course merge(Course detachedInstance) {
		log.debug("merging Course instance");
		try {
			Course result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Course findById(String id) {
		log.debug("getting Course instance with id: " + id);
		try {
			Course instance = entityManager.find(Course.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
