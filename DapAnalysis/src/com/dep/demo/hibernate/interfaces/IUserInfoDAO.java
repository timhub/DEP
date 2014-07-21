package com.dep.demo.hibernate.interfaces;

import java.util.List;

import com.dep.demo.hibernate.pojo.UserInfo;

public interface IUserInfoDAO {

	// property constants
	public static final String USER_NAME = "userName";
	public static final String USER_PASS = "userPass";
	public static final String USER_ROLE = "userRole";
	public static final String USER_RIGHTS = "userRights";
	public static final String LAST_LOGIN_DATE = "lastLoginDate";
	public static final String EMAIL = "email";
	public static final String CHANGED = "changed";
	public static final String STATUS = "status";

	public abstract void save(UserInfo transientInstance);

	public abstract void delete(UserInfo persistentInstance);

	public abstract UserInfo findById(java.lang.Integer id);

	public abstract List findByExample(UserInfo instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUserName(Object userName);

	public abstract List findByUserPass(Object userPass);

	public abstract List findByUserRole(Object userRole);

	public abstract List findByUserRights(Object userRights);

	public abstract List findByLastLoginDate(Object lastLoginDate);

	public abstract List findByEmail(Object email);

	public abstract List findByChanged(Object changed);

	public abstract List findByStatus(Object status);

	public abstract List findAll();

	public abstract UserInfo merge(UserInfo detachedInstance);

	public abstract void attachDirty(UserInfo instance);

	public abstract void attachClean(UserInfo instance);

}