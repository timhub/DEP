package com.dep.demo;

public class CSVDataBean {
	private String bug_id;
	private String bug_severity;
	private String priority;
	private String op_sys;
	private String assigned_to;
	private String bug_status;
	private String resolution;
	private String short_desc;
	private String component;
	private String product;
	private String release_date;
	private String classification;
	private boolean componentFlag = false;
	
	public String getBug_id() {
		return bug_id;
	}
	public void setBug_id(String bug_id) {
		this.bug_id = bug_id;
	}
	public String getBug_severity() {
		return bug_severity;
	}
	public void setBug_severity(String bug_severity) {
		this.bug_severity = bug_severity;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getOp_sys() {
		return op_sys;
	}
	public void setOp_sys(String op_sys) {
		this.op_sys = op_sys;
	}
	public String getAssigned_to() {
		return assigned_to;
	}
	public void setAssigned_to(String assigned_to) {
		this.assigned_to = assigned_to;
	}
	public String getBug_status() {
		return bug_status;
	}
	public void setBug_status(String bug_status) {
		this.bug_status = bug_status;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getShort_desc() {
		return short_desc;
	}
	public void setShort_desc(String short_desc) {
		this.short_desc = short_desc;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public boolean isComponentFlag() {
		return componentFlag;
	}
	public void setComponentFlag(boolean componentFlag) {
		this.componentFlag = componentFlag;
	}
}
