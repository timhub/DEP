package com.dep.demo.hibernate.pojo;

/**
 * BugInfo entity. @author MyEclipse Persistence Tools
 */

public class BugInfo implements java.io.Serializable {

	// Fields

	private Integer bugId;
	private BugType bugType;
	private Integer bugInfId;
	private String product;
	private String component;
	private String assignee;
	private String status;
	private String resolution;
	private String summary;
	private String changed;
	private String attach1;
	private String attach2;
	private String attach3;
	private String attach4;
	private String attach5;

	// Constructors

	/** default constructor */
	public BugInfo() {
	}

	/** minimal constructor */
	public BugInfo(Integer bugInfId) {
		this.bugInfId = bugInfId;
	}

	/** full constructor */
	public BugInfo(BugType bugType, Integer bugInfId, String product,
			String component, String assignee, String status,
			String resolution, String summary, String changed, String attach1,
			String attach2, String attach3, String attach4, String attach5) {
		this.bugType = bugType;
		this.bugInfId = bugInfId;
		this.product = product;
		this.component = component;
		this.assignee = assignee;
		this.status = status;
		this.resolution = resolution;
		this.summary = summary;
		this.changed = changed;
		this.attach1 = attach1;
		this.attach2 = attach2;
		this.attach3 = attach3;
		this.attach4 = attach4;
		this.attach5 = attach5;
	}

	// Property accessors

	public Integer getBugId() {
		return this.bugId;
	}

	public void setBugId(Integer bugId) {
		this.bugId = bugId;
	}

	public BugType getBugType() {
		return this.bugType;
	}

	public void setBugType(BugType bugType) {
		this.bugType = bugType;
	}

	public Integer getBugInfId() {
		return this.bugInfId;
	}

	public void setBugInfId(Integer bugInfId) {
		this.bugInfId = bugInfId;
	}

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getComponent() {
		return this.component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getAssignee() {
		return this.assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResolution() {
		return this.resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public String getAttach4() {
		return this.attach4;
	}

	public void setAttach4(String attach4) {
		this.attach4 = attach4;
	}

	public String getAttach5() {
		return this.attach5;
	}

	public void setAttach5(String attach5) {
		this.attach5 = attach5;
	}

}