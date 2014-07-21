package com.dep.demo.hibernate.pojo;

/**
 * BugTypeSub entity. @author MyEclipse Persistence Tools
 */

public class BugTypeSub implements java.io.Serializable {

	// Fields

	private Integer bugTypeSubId;
	private String bugTypeSubCategory;
	private String changed;
	private String attach1;
	private String attach2;
	private String attach3;
	private Integer bugTypeId;
	private Boolean isSelected;

	// Constructors

	/** default constructor */
	public BugTypeSub() {
	}

	/** full constructor */
	public BugTypeSub(String bugTypeSubCategory, String changed,
			String attach1, String attach2, String attach3, Integer bugTypeId,
			Boolean isSelected) {
		this.bugTypeSubCategory = bugTypeSubCategory;
		this.changed = changed;
		this.attach1 = attach1;
		this.attach2 = attach2;
		this.attach3 = attach3;
		this.bugTypeId = bugTypeId;
		this.isSelected = isSelected;
	}

	// Property accessors

	public Integer getBugTypeSubId() {
		return this.bugTypeSubId;
	}

	public void setBugTypeSubId(Integer bugTypeSubId) {
		this.bugTypeSubId = bugTypeSubId;
	}

	public String getBugTypeSubCategory() {
		return this.bugTypeSubCategory;
	}

	public void setBugTypeSubCategory(String bugTypeSubCategory) {
		this.bugTypeSubCategory = bugTypeSubCategory;
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

	public Integer getBugTypeId() {
		return this.bugTypeId;
	}

	public void setBugTypeId(Integer bugTypeId) {
		this.bugTypeId = bugTypeId;
	}

	public Boolean getIsSelected() {
		return this.isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}

}