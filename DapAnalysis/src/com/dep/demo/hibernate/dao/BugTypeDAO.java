package com.dep.demo.hibernate.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dep.demo.hibernate.interfaces.IBugTypeDAO;
import com.dep.demo.hibernate.pojo.BugType;

/**
 * A data access object (DAO) providing persistence and search support for
 * BugType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.dep.demo.hibernate.pojo.BugType
 * @author MyEclipse Persistence Tools
 */

public class BugTypeDAO extends BaseHibernateDAO implements IBugTypeDAO {
	private static final Logger log = LoggerFactory.getLogger(BugTypeDAO.class);
	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeDAO#save(com.dep.demo.hibernate.pojo.BugType)
	 */
	public void save(BugType transientInstance) {
		log.debug("saving BugType instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeDAO#delete(com.dep.demo.hibernate.pojo.BugType)
	 */
	public void delete(BugType persistentInstance) {
		log.debug("deleting BugType instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeDAO#findById(java.lang.Integer)
	 */
	public BugType findById(java.lang.Integer id) {
		log.debug("getting BugType instance with id: " + id);
		try {
			BugType instance = (BugType) getSession().get(
					"com.dep.demo.hibernate.pojo.BugType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeDAO#findByExample(com.dep.demo.hibernate.pojo.BugType)
	 */
	public List findByExample(BugType instance) {
		log.debug("finding BugType instance by example");
		try {
			List results = getSession().createCriteria(
					"com.dep.demo.hibernate.pojo.BugType").add(
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
	 * @see com.dep.demo.hibernate.dao.IBugTypeDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BugType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BugType as model where model."
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
	 * @see com.dep.demo.hibernate.dao.IBugTypeDAO#findByBugTypeCategory(java.lang.Object)
	 */
	public List findByBugTypeCategory(Object bugTypeCategory) {
		return findByProperty(BUG_TYPE_CATEGORY, bugTypeCategory);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeDAO#findByChanged(java.lang.Object)
	 */
	public List findByChanged(Object changed) {
		return findByProperty(CHANGED, changed);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeDAO#findByAttach1(java.lang.Object)
	 */
	public List findByAttach1(Object attach1) {
		return findByProperty(ATTACH1, attach1);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeDAO#findByAttach2(java.lang.Object)
	 */
	public List findByAttach2(Object attach2) {
		return findByProperty(ATTACH2, attach2);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeDAO#findByAttach3(java.lang.Object)
	 */
	public List findByAttach3(Object attach3) {
		return findByProperty(ATTACH3, attach3);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeDAO#findByBugTypeSubCategory(java.lang.Object)
	 */
	public List findByBugTypeSubCategory(Object bugTypeSubCategory) {
		return findByProperty(BUG_TYPE_SUB_CATEGORY, bugTypeSubCategory);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeDAO#findByBugTypeSubNumber(java.lang.Object)
	 */
	public List findByBugTypeSubNumber(Object bugTypeSubNumber) {
		return findByProperty(BUG_TYPE_SUB_NUMBER, bugTypeSubNumber);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all BugType instances");
		try {
			String queryString = "from BugType";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeDAO#merge(com.dep.demo.hibernate.pojo.BugType)
	 */
	public BugType merge(BugType detachedInstance) {
		log.debug("merging BugType instance");
		try {
			BugType result = (BugType) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeDAO#attachDirty(com.dep.demo.hibernate.pojo.BugType)
	 */
	public void attachDirty(BugType instance) {
		log.debug("attaching dirty BugType instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugTypeDAO#attachClean(com.dep.demo.hibernate.pojo.BugType)
	 */
	public void attachClean(BugType instance) {
		log.debug("attaching clean BugType instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}