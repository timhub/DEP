package com.dep.demo.hibernate.interfaces;

import java.util.List;

import com.dep.demo.hibernate.pojo.BugInfo;

public interface IBugInfoDAO {

	// property constants
	public static final String BUG_INF_ID = "bugInfId";
	public static final String PRODUCT = "product";
	public static final String COMPONENT = "component";
	public static final String ASSIGNEE = "assignee";
	public static final String STATUS = "status";
	public static final String RESOLUTION = "resolution";
	public static final String SUMMARY = "summary";
	public static final String CHANGED = "changed";
	public static final String ATTACH1 = "attach1";
	public static final String ATTACH2 = "attach2";
	public static final String ATTACH3 = "attach3";
	public static final String ATTACH4 = "attach4";
	public static final String ATTACH5 = "attach5";

	public abstract void save(BugInfo transientInstance);

	public abstract void delete(BugInfo persistentInstance);

	public abstract BugInfo findById(java.lang.Integer id);

	public abstract List findByExample(BugInfo instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByBugInfId(Object bugInfId);

	public abstract List findByProduct(Object product);

	public abstract List findByComponent(Object component);

	public abstract List findByAssignee(Object assignee);

	public abstract List findByStatus(Object status);

	public abstract List findByResolution(Object resolution);

	public abstract List findBySummary(Object summary);

	public abstract List findByChanged(Object changed);

	public abstract List findByAttach1(Object attach1);

	public abstract List findByAttach2(Object attach2);

	public abstract List findByAttach3(Object attach3);

	public abstract List findByAttach4(Object attach4);

	public abstract List findByAttach5(Object attach5);

	public abstract List findAll();

	public abstract BugInfo merge(BugInfo detachedInstance);

	public abstract void attachDirty(BugInfo instance);

	public abstract void attachClean(BugInfo instance);

}