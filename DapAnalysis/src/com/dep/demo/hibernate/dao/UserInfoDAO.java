package com.dep.demo.hibernate.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dep.demo.hibernate.interfaces.IUserInfoDAO;
import com.dep.demo.hibernate.pojo.UserInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.dep.demo.hibernate.pojo.UserInfo
 * @author MyEclipse Persistence Tools
 */

public class UserInfoDAO extends BaseHibernateDAO implements IUserInfoDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserInfoDAO.class);
	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#save(com.dep.demo.hibernate.pojo.UserInfo)
	 */
	public void save(UserInfo transientInstance) {
		log.debug("saving UserInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#delete(com.dep.demo.hibernate.pojo.UserInfo)
	 */
	public void delete(UserInfo persistentInstance) {
		log.debug("deleting UserInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#findById(java.lang.Integer)
	 */
	public UserInfo findById(java.lang.Integer id) {
		log.debug("getting UserInfo instance with id: " + id);
		try {
			UserInfo instance = (UserInfo) getSession().get(
					"com.dep.demo.hibernate.pojo.UserInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#findByExample(com.dep.demo.hibernate.pojo.UserInfo)
	 */
	public List findByExample(UserInfo instance) {
		log.debug("finding UserInfo instance by example");
		try {
			List results = getSession().createCriteria(
					"com.dep.demo.hibernate.pojo.UserInfo").add(
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
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding UserInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserInfo as model where model."
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
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#findByUserName(java.lang.Object)
	 */
	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#findByUserPass(java.lang.Object)
	 */
	public List findByUserPass(Object userPass) {
		return findByProperty(USER_PASS, userPass);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#findByUserRole(java.lang.Object)
	 */
	public List findByUserRole(Object userRole) {
		return findByProperty(USER_ROLE, userRole);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#findByUserRights(java.lang.Object)
	 */
	public List findByUserRights(Object userRights) {
		return findByProperty(USER_RIGHTS, userRights);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#findByLastLoginDate(java.lang.Object)
	 */
	public List findByLastLoginDate(Object lastLoginDate) {
		return findByProperty(LAST_LOGIN_DATE, lastLoginDate);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#findByEmail(java.lang.Object)
	 */
	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#findByChanged(java.lang.Object)
	 */
	public List findByChanged(Object changed) {
		return findByProperty(CHANGED, changed);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#findByStatus(java.lang.Object)
	 */
	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#merge(com.dep.demo.hibernate.pojo.UserInfo)
	 */
	public UserInfo merge(UserInfo detachedInstance) {
		log.debug("merging UserInfo instance");
		try {
			UserInfo result = (UserInfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#attachDirty(com.dep.demo.hibernate.pojo.UserInfo)
	 */
	public void attachDirty(UserInfo instance) {
		log.debug("attaching dirty UserInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dep.demo.hibernate.dao.IUserInfoDAO#attachClean(com.dep.demo.hibernate.pojo.UserInfo)
	 */
	public void attachClean(UserInfo instance) {
		log.debug("attaching clean UserInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}