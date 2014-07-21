package com.test.users;

import java.util.Map;

import com.test.entity.UserLoginData;
import com.test.mockups.UserLoginService;

public class UserLoginBackingBean {
	private String username;
	private String password;
	
	UserLoginService service = new UserLoginService();
	private Map<String,UserLoginData> UserInfoMap = service.getUserInfoMap();
	
	
	
	public UserLoginBackingBean() {
		super();
		System.out.println("55555555555555555555555555555555555555555");
	}

	public String checkUserData(){
		String name = this.getUsername();
		String pass = this.getPassword();
		
		if(UserInfoMap.containsKey(name)){
			UserLoginData inputdata = UserInfoMap.get(name);
			if(inputdata.getPassword()==pass){
				//login success
				return "sccess";
			}else{
				//password fail
				return "1";
			}
		}else{
			//user doesn't exist
			return "2";
		}		
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
