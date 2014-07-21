package com.dep.demo.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dep.demo.hibernate.dao.BugInfoDAO;
import com.dep.demo.hibernate.pojo.BugInfo;

public class BugInfoDAOExt extends BugInfoDAO {
	public void save(BugInfo transientInstance) {
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
