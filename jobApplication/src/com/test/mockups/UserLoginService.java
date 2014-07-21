package com.test.mockups;

import java.util.HashMap;
import java.util.Map;

import com.test.entity.UserLoginData;

public class UserLoginService {
	
	private Map<String,UserLoginData> UserInfoMap = new HashMap<String,UserLoginData>();
	
	public UserLoginService(){
		super();
		startLoginService();
	}
	
	public void startLoginService(){
		
		UserLoginData user1 = new UserLoginData("timothy","123456");
		UserLoginData user2 = new UserLoginData("tom","123456");
		UserLoginData user3 = new UserLoginData("bob","123456");
		UserLoginData user4 = new UserLoginData("keane","123456");
		UserInfoMap.put("timothy", user1);
		UserInfoMap.put("tom", user2);
		UserInfoMap.put("bob", user3);
		UserInfoMap.put("keane", user4);
	}
	
	public Map<String, UserLoginData> getUserInfoMap() {
		return UserInfoMap;
	}

	public void setUserInfoMap(Map<String, UserLoginData> userInfoMap) {
		UserInfoMap = userInfoMap;
	}
	
}
