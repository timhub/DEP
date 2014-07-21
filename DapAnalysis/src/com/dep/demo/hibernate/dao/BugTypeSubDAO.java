package com.dep.demo.hibernate.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dep.demo.hibernate.interfaces.IBugTypeSubDAO;
import com.dep.demo.hibernate.pojo.BugTypeSub;

/**
 * A data access object (DAO) providing persistence and search support for
 * BugTypeSub entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.dep.demo.hibernate.pojo.BugTypeSub
 * @author MyEclipse Persistence Tools
 */

public class BugTypeSubDAO extends BaseHibernateDAO implements IBugTypeSubDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BugTypeSubDAO.class);
	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeSubDAO#save(com.dep.demo.hibernate.pojo.BugTypeSub)
	 */
	public void save(BugTypeSub transientInstance) {
		log.debug("saving BugTypeSub instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeSubDAO#delete(com.dep.demo.hibernate.pojo.BugTypeSub)
	 */
	public void delete(BugTypeSub persistentInstance) {
		log.debug("deleting BugTypeSub instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeSubDAO#findById(java.lang.Integer)
	 */
	public BugTypeSub findById(java.lang.Integer id) {
		log.debug("getting BugTypeSub instance with id: " + id);
		try {
			BugTypeSub instance = (BugTypeSub) getSession().get(
					"com.dep.demo.hibernate.pojo.BugTypeSub", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeSubDAO#findByExample(com.dep.demo.hibernate.pojo.BugTypeSub)
	 */
	public List findByExample(BugTypeSub instance) {
		log.debug("finding BugTypeSub instance by example");
		try {
			List results = getSession().createCriteria(
					"com.dep.demo.hibernate.pojo.BugTypeSub").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeSubDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BugTypeSub instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BugTypeSub as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeSubDAO#findByBugTypeSubCategory(java.lang.Object)
	 */
	public List findByBugTypeSubCategory(Object bugTypeSubCategory) {
		return findByProperty(BUG_TYPE_SUB_CATEGORY, bugTypeSubCategory);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeSubDAO#findByChanged(java.lang.Object)
	 */
	public List findByChanged(Object changed) {
		return findByProperty(CHANGED, changed);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeSubDAO#findByAttach1(java.lang.Object)
	 */
	public List findByAttach1(Object attach1) {
		return findByProperty(ATTACH1, attach1);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeSubDAO#findByAttach2(java.lang.Object)
	 */
	public List findByAttach2(Object attach2) {
		return findByProperty(ATTACH2, attach2);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeSubDAO#findByAttach3(java.lang.Object)
	 */
	public List findByAttach3(Object attach3) {
		return findByProperty(ATTACH3, attach3);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeSubDAO#findByBugTypeId(java.lang.Object)
	 */
	public List findByBugTypeId(Object bugTypeId) {
		return findByProperty(BUG_TYPE_ID, bugTypeId);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeSubDAO#findByIsSelected(java.lang.Object)
	 */
	public List findByIsSelected(Object isSelected) {
		return findByProperty(IS_SELECTED, isSelected);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeSubDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all BugTypeSub instances");
		try {
			String queryString = "from BugTypeSub";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeSubDAO#merge(com.dep.demo.hibernate.pojo.BugTypeSub)
	 */
	public BugTypeSub merge(BugTypeSub detachedInstance) {
		log.debug("merging BugTypeSub instance");
		try {
			BugTypeSub result = (BugTypeSub) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeSubDAO#attachDirty(com.dep.demo.hibernate.pojo.BugTypeSub)
	 */
	public void attachDirty(BugTypeSub instance) {
		log.debug("attaching dirty BugTypeSub instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeSubDAO#attachClean(com.dep.demo.hibernate.pojo.BugTypeSub)
	 */
	public void attachClean(BugTypeSub instance) {
		log.debug("attaching clean BugTypeSub instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}