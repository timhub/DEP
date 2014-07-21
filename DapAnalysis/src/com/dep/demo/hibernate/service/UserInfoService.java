package com.dep.demo.hibernate.service;

import java.util.List;

import com.dep.demo.hibernate.dao.impl.UserInfoDAOExt;
import com.dep.demo.hibernate.interfaces.IUserInfoDAO;
import com.dep.demo.hibernate.pojo.UserInfo;

public class UserInfoService {
	
	private IUserInfoDAO iUserInfoDAO = new UserInfoDAOExt();
	
	public void save(UserInfo info){
		iUserInfoDAO.save(info);
	}
	
	public List<UserInfo> findAll(){
		return iUserInfoDAO.findAll();
	}

}
