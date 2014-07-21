package com.dep.demo.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dep.demo.hibernate.dao.BugTypeDAO;
import com.dep.demo.hibernate.pojo.BugType;

public class BugTypeDAOExt extends BugTypeDAO{
	public void save(BugType transientInstance) {
		Session session = this.getSession();
		Transaction tran = session.getTransaction();
		try{
			tran.begin();
			session.save(transientInstance);
			tran.commit();
		} catch (RuntimeException e){
			throw e;
		} finally{
			session.flush();
			session.close();
		}
	}
	
	public List findAll(){
		Session session = this.getSession();
		Transaction tran = session.getTransaction();
		try {
			tran.begin();
			String queryString = "from BugType";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		} finally{
			session.flush();
			session.close();
		}
	}
}
