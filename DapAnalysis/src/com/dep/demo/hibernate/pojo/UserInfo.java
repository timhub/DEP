package com.dep.demo.hibernate.pojo;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String userPass;
	private String userRole;
	private String userRights;
	private String lastLoginDate;
	private String email;
	private String changed;
	private Integer status;

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** full constructor */
	public UserInfo(String userName, String userPass, String userRole,
			String userRights, String lastLoginDate, String email,
			String changed, Integer status) {
		this.userName = userName;
		this.userPass = userPass;
		this.userRole = userRole;
		this.userRights = userRights;
		this.lastLoginDate = lastLoginDate;
		this.email = email;
		this.changed = changed;
		this.status = status;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserRights() {
		return this.userRights;
	}

	public void setUserRights(String userRights) {
		this.userRights = userRights;
	}

	public String getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getChanged() {
		return this.changed;
	}

	public void setChanged(String changed) {
		this.changed = changed;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}