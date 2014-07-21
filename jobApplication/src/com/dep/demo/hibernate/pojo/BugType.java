package com.dep.demo.hibernate.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * BugType entity. @author MyEclipse Persistence Tools
 */

public class BugType implements java.io.Serializable {

	// Fields

	private Integer bugTypeId;
	private String bugTypeCategory;
	private String changed;
	private String attach1;
	private String attach2;
	private String attach3;
	private String bugTypeSubCategory;
	private String bugTypeSubNumber;
	private Set bugInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public BugType() {
	}

	/** full constructor */
	public BugType(String bugTypeCategory, String changed, String attach1,
			String attach2, String attach3, String bugTypeSubCategory,
			String bugTypeSubNumber, Set bugInfos) {
		this.bugTypeCategory = bugTypeCategory;
		this.changed = changed;
		this.attach1 = attach1;
		this.attach2 = attach2;
		this.attach3 = attach3;
		this.bugTypeSubCategory = bugTypeSubCategory;
		this.bugTypeSubNumber = bugTypeSubNumber;
		this.bugInfos = bugInfos;
	}

	// Property accessors

	public Integer getBugTypeId() {
		return this.bugTypeId;
	}

	public void setBugTypeId(Integer bugTypeId) {
		this.bugTypeId = bugTypeId;
	}

	public String getBugTypeCategory() {
		return this.bugTypeCategory;
	}

	public void setBugTypeCategory(String bugTypeCategory) {
		this.bugTypeCategory = bugTypeCategory;
	}

	public String getChanged() {
		return this.changed;
	}

	public void setChanged(String changed) {
		this.changed = changed;
	}

	public String getAttach1() {
		return this.attach1;
	}

	public void setAttach1(String attach1) {
		this.attach1 = attach1;
	}

	public String getAttach2() {
		return this.attach2;
	}

	public void setAttach2(String attach2) {
		this.attach2 = attach2;
	}

	public String getAttach3() {
		return this.attach3;
	}

	public void setAttach3(String attach3) {
		this.attach3 = attach3;
	}

	public String getBugTypeSubCategory() {
		return this.bugTypeSubCategory;
	}

	public void setBugTypeSubCategory(String bugTypeSubCategory) {
		this.bugTypeSubCategory = bugTypeSubCategory;
	}

	public String getBugTypeSubNumber() {
		return this.bugTypeSubNumber;
	}

	public void setBugTypeSubNumber(String bugTypeSubNumber) {
		this.bugTypeSubNumber = bugTypeSubNumber;
	}

	public Set getBugInfos() {
		return this.bugInfos;
	}

	public void setBugInfos(Set bugInfos) {
		this.bugInfos = bugInfos;
	}

}