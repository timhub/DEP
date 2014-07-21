package com.dep.demo.hibernate.pojo;

public class Project implements java.io.Serializable {

	private Integer projectId;
	private Integer productId;
	private String projectName;
	private String projectDesc;
	private String attach1;
	private String attach2;
	private String attach3;
	private String createOn;
	
	public Project() {
	}

	public Project(Integer projectId, Integer productId, String projectName,
			String projectDesc, String attach1, String attach2, String attach3,
			String createOn) {
		super();
		this.projectId = projectId;
		this.productId = productId;
		this.projectName = projectName;
		this.projectDesc = projectDesc;
		this.attach1 = attach1;
		this.attach2 = attach2;
		this.attach3 = attach3;
		this.createOn = createOn;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public String getAttach1() {
		return attach1;
	}

	public void setAttach1(String attach1) {
		this.attach1 = attach1;
	}

	public String getAttach2() {
		return attach2;
	}

	public void setAttach2(String attach2) {
		this.attach2 = attach2;
	}

	public String getAttach3() {
		return attach3;
	}

	public void setAttach3(String attach3) {
		this.attach3 = attach3;
	}

	public String getCreateOn() {
		return createOn;
	}

	public void setCreateOn(String createOn) {
		this.createOn = createOn;
	}
	
	
}
