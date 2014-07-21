package com.dep.demo.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dep.demo.hibernate.dao.UserInfoDAO;
import com.dep.demo.hibernate.pojo.UserInfo;

public class UserInfoDAOExt extends UserInfoDAO {

	public void save(UserInfo transientInstance) {
		Session session = this.getSession();
		Transaction tran = session.getTransaction();
		try {
			tran.begin();
			session.save(transientInstance);
			tran.commit();
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.flush();
			session.close();
		}
	}



}
