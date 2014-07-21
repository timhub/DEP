package com.dep.demo;

public class ClassificationDataBean {
	private String colData;
	private int count;
	private String percentage;
	
	private boolean displayClassFlag = false;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getColData() {
		return colData;
	}
	public void setColData(String colData) {
		this.colData = colData;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public boolean isDisplayClassFlag() {
		return displayClassFlag;
	}
	public void setDisplayClassFlag(boolean displayClassFlag) {
		this.displayClassFlag = displayClassFlag;
	}
}
