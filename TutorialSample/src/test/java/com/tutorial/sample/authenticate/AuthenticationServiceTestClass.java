package com.tutorial.sample.authenticate;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

//import com.tutorial.sample.authenticate.AuthenticationService;
//import com.tutorial.sample.authenticate.UserInfo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//This class Tests Authentication with User
public class AuthenticationServiceTestClass {
	//UserDao userdao = new UserDao();	
	Dao dataObj;
	
	AuthenticationService authServ;

	UserInfo userInfo = new UserInfo();

	private UserInfo storeduserinfo = new UserInfo();

	@Before
	public void createTestUser(){
		//UI Inputs
		userInfo.UserName = "Nihal";
		userInfo.Password = "nihalPassword";
		
		//Creating Stored User
		storeduserinfo.Password = "nihalPassword";
		storeduserinfo.UserName = "Nihal";
	}
	
	@Test
	public void checkAuthenticateUser(){
		createMockDao();
		
		authServ = new AuthenticationService(dataObj);
		
		Boolean authenticated = authServ.AuthenticateUser(userInfo);
		
		Mockito.verify(dataObj).getUser_byName();
		
		assertEquals(true, authenticated);
		
	}
	
	@After
	public void clearUserInfo(){
		userInfo = null;
		authServ = null;
	}
	
	public void createMockDao(){
		dataObj=mock(Dao.class);
		
		//authServ
		when(dataObj.getUser_byName()).thenReturn((UserInfo) storeduserinfo);
	}
}
