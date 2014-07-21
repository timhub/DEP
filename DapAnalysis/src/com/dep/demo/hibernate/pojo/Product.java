package com.dep.demo.hibernate.pojo;

public class Product implements java.io.Serializable {

	private Integer productId;
	private String productName;
	private String productDesc;
	private String attach1;
	private String attach2;
	private String attach3;
	private String createOn;
	
	public Product() {
	}
	
	public Product(Integer productId, String productName, String productDesc,
			String attach1, String attach2, String attach3, String createOn) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.attach1 = attach1;
		this.attach2 = attach2;
		this.attach3 = attach3;
		this.createOn = createOn;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
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
