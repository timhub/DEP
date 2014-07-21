package com.dep.demo.hibernate.interfaces;

import java.util.List;

import com.dep.demo.hibernate.pojo.BugType;

public interface IBugTypeDAO {

	// property constants
	public static final String BUG_TYPE_CATEGORY = "bugTypeCategory";
	public static final String CHANGED = "changed";
	public static final String ATTACH1 = "attach1";
	public static final String ATTACH2 = "attach2";
	public static final String ATTACH3 = "attach3";
	public static final String BUG_TYPE_SUB_CATEGORY = "bugTypeSubCategory";
	public static final String BUG_TYPE_SUB_NUMBER = "bugTypeSubNumber";

	public abstract void save(BugType transientInstance);

	public abstract void delete(BugType persistentInstance);

	public abstract BugType findById(java.lang.Integer id);

	public abstract List findByExample(BugType instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByBugTypeCategory(Object bugTypeCategory);

	public abstract List findByChanged(Object changed);

	public abstract List findByAttach1(Object attach1);

	public abstract List findByAttach2(Object attach2);

	public abstract List findByAttach3(Object attach3);

	public abstract List findByBugTypeSubCategory(Object bugTypeSubCategory);

	public abstract List findByBugTypeSubNumber(Object bugTypeSubNumber);

	public abstract List findAll();

	public abstract BugType merge(BugType detachedInstance);

	public abstract void attachDirty(BugType instance);

	public abstract void attachClean(BugType instance);

}