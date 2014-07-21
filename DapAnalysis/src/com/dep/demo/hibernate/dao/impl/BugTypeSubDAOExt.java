package com.dep.demo.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dep.demo.hibernate.dao.BugTypeSubDAO;
import com.dep.demo.hibernate.pojo.BugTypeSub;

public class BugTypeSubDAOExt extends BugTypeSubDAO {
	public BugTypeSub findById(int id) {
		Session session = this.getSession();
		Transaction tran = session.getTransaction();
		try {
			tran.begin();
			BugTypeSub instance = (BugTypeSub) getSession().get(
					"com.dep.demo.hibernate.pojo.BugTypeSub", id);
			
			return instance;
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.flush();
			session.close();
		}
	}
	
	public void save(BugTypeSub transientInstance) {
		Session session = this.getSession();
		Transaction tran = session.getTransaction();
		try {
			tran.begin();
			getSession().save(transientInstance);
			tran.commit();
		} catch (RuntimeException re) {
			throw re;
		} finally {
			session.flush();
			session.close();
		}
	}
}
