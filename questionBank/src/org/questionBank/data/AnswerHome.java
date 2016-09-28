package org.questionBank.data;
// Generated Sep 13, 2016 2:54:40 AM by Hibernate Tools 5.1.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Answer.
 * @see org.questionBank.data.Answer
 * @author Hibernate Tools
 */
@Stateless
public class AnswerHome {

	private static final Log log = LogFactory.getLog(AnswerHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Answer transientInstance) {
		log.debug("persisting Answer instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Answer persistentInstance) {
		log.debug("removing Answer instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Answer merge(Answer detachedInstance) {
		log.debug("merging Answer instance");
		try {
			Answer result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Answer findById(String id) {
		log.debug("getting Answer instance with id: " + id);
		try {
			Answer instance = entityManager.find(Answer.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}