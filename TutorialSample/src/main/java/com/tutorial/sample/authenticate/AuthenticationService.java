package com.tutorial.sample.authenticate;

public class AuthenticationService {

	public Dao dao;
	

	public AuthenticationService(Dao dataObj) {
		// TODO Auto-generated constructor stub
		this.dao = dataObj;
	}

	public Boolean AuthenticateUser(UserInfo userInfo) {
		UserInfo user_real;
		
		user_real = (UserInfo) dao.getUser_byName();
		
		if(user_real.UserName.equals(userInfo.UserName) && user_real.Password.equals(userInfo.Password)){
			return true;
		}
		else{
			return false;
		}
	}
	
	

}
