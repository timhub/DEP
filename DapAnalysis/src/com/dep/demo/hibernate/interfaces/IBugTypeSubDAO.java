package com.dep.demo.hibernate.interfaces;

import java.util.List;

import com.dep.demo.hibernate.pojo.BugTypeSub;

public interface IBugTypeSubDAO {

	// property constants
	public static final String BUG_TYPE_SUB_CATEGORY = "bugTypeSubCategory";
	public static final String CHANGED = "changed";
	public static final String ATTACH1 = "attach1";
	public static final String ATTACH2 = "attach2";
	public static final String ATTACH3 = "attach3";
	public static final String BUG_TYPE_ID = "bugTypeId";
	public static final String IS_SELECTED = "isSelected";

	public abstract void save(BugTypeSub transientInstance);

	public abstract void delete(BugTypeSub persistentInstance);

	public abstract BugTypeSub findById(java.lang.Integer id);

	public abstract List findByExample(BugTypeSub instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByBugTypeSubCategory(Object bugTypeSubCategory);

	public abstract List findByChanged(Object changed);

	public abstract List findByAttach1(Object attach1);

	public abstract List findByAttach2(Object attach2);

	public abstract List findByAttach3(Object attach3);

	public abstract List findByBugTypeId(Object bugTypeId);

	public abstract List findByIsSelected(Object isSelected);

	public abstract List findAll();

	public abstract BugTypeSub merge(BugTypeSub detachedInstance);

	public abstract void attachDirty(BugTypeSub instance);

	public abstract void attachClean(BugTypeSub instance);

}