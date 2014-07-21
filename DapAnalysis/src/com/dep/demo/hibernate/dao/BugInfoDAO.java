package com.dep.demo.hibernate.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dep.demo.hibernate.interfaces.IBugInfoDAO;
import com.dep.demo.hibernate.pojo.BugInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * BugInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.dep.demo.hibernate.pojo.BugInfo
 * @author MyEclipse Persistence Tools
 */

public class BugInfoDAO extends BaseHibernateDAO implements IBugInfoDAO {
	private static final Logger log = LoggerFactory.getLogger(BugInfoDAO.class);
	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#save(com.dep.demo.hibernate.pojo.BugInfo)
	 */
	public void save(BugInfo transientInstance) {
		log.debug("saving BugInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#delete(com.dep.demo.hibernate.pojo.BugInfo)
	 */
	public void delete(BugInfo persistentInstance) {
		log.debug("deleting BugInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findById(java.lang.Integer)
	 */
	public BugInfo findById(java.lang.Integer id) {
		log.debug("getting BugInfo instance with id: " + id);
		try {
			BugInfo instance = (BugInfo) getSession().get(
					"com.dep.demo.hibernate.pojo.BugInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findByExample(com.dep.demo.hibernate.pojo.BugInfo)
	 */
	public List findByExample(BugInfo instance) {
		log.debug("finding BugInfo instance by example");
		try {
			List results = getSession().createCriteria(
					"com.dep.demo.hibernate.pojo.BugInfo").add(
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
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BugInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BugInfo as model where model."
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
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findByBugInfId(java.lang.Object)
	 */
	public List findByBugInfId(Object bugInfId) {
		return findByProperty(BUG_INF_ID, bugInfId);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findByProduct(java.lang.Object)
	 */
	public List findByProduct(Object product) {
		return findByProperty(PRODUCT, product);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findByComponent(java.lang.Object)
	 */
	public List findByComponent(Object component) {
		return findByProperty(COMPONENT, component);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findByAssignee(java.lang.Object)
	 */
	public List findByAssignee(Object assignee) {
		return findByProperty(ASSIGNEE, assignee);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findByStatus(java.lang.Object)
	 */
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findByResolution(java.lang.Object)
	 */
	public List findByResolution(Object resolution) {
		return findByProperty(RESOLUTION, resolution);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findBySummary(java.lang.Object)
	 */
	public List findBySummary(Object summary) {
		return findByProperty(SUMMARY, summary);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findByChanged(java.lang.Object)
	 */
	public List findByChanged(Object changed) {
		return findByProperty(CHANGED, changed);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findByAttach1(java.lang.Object)
	 */
	public List findByAttach1(Object attach1) {
		return findByProperty(ATTACH1, attach1);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findByAttach2(java.lang.Object)
	 */
	public List findByAttach2(Object attach2) {
		return findByProperty(ATTACH2, attach2);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findByAttach3(java.lang.Object)
	 */
	public List findByAttach3(Object attach3) {
		return findByProperty(ATTACH3, attach3);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findByAttach4(java.lang.Object)
	 */
	public List findByAttach4(Object attach4) {
		return findByProperty(ATTACH4, attach4);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findByAttach5(java.lang.Object)
	 */
	public List findByAttach5(Object attach5) {
		return findByProperty(ATTACH5, attach5);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all BugInfo instances");
		try {
			String queryString = "from BugInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#merge(com.dep.demo.hibernate.pojo.BugInfo)
	 */
	public BugInfo merge(BugInfo detachedInstance) {
		log.debug("merging BugInfo instance");
		try {
			BugInfo result = (BugInfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#attachDirty(com.dep.demo.hibernate.pojo.BugInfo)
	 */
	public void attachDirty(BugInfo instance) {
		log.debug("attaching dirty BugInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IBugInfoDAO#attachClean(com.dep.demo.hibernate.pojo.BugInfo)
	 */
	public void attachClean(BugInfo instance) {
		log.debug("attaching clean BugInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}