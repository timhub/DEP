package com.dep.demo;

public class DAPAnylisisItem {
	private String issueName;
	private String issueAmount;
	private String persentage;
	private String num;
	private int flag = 0;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getPersentage() {
		return persentage;
	}
	public void setPersentage(String persentage) {
		this.persentage = persentage;
	}
	public String getIssueName() {
		return issueName;
	}
	public void setIssueName(String issueName) {
//		if("".equals(issueName)){
//			this.issueName = "[Not Defined]";
//		}else{
			this.issueName = issueName;
//		}
	}
	public String getIssueAmount() {
		return issueAmount;
	}
	public void setIssueAmount(String issueAmount) {
//		if("".equals(issueAmount)){
//			this.issueAmount = "0";
//		}else{
			this.issueAmount = issueAmount;
//		}
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
