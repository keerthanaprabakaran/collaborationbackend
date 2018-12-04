package com.niit.collabrationbackend;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.DAO.UserDAO;
import com.niit.collaboration.model.User;

import jdk.nashorn.internal.ir.annotations.Ignore;
import junit.framework.Assert;

public class UserTestCase {

	
	@Autowired  static AnnotationConfigApplicationContext context;
	
	@Autowired  static User user;
	
	@Autowired  static UserDAO  userDAO;
	
	
	
	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		user = (User) context.getBean("user");
		
		userDAO = (UserDAO) context.getBean("userDAO");
		 
	}
	
	
	/*
	@Test
	public void deleteUserTestCase()
	{
		boolean user =  userDAO.delete("sourabh");
		
		assertEquals("getUserTestCase", null, user);
		
	}*/
	/*@Test
	
	public void validateCredentialsTestCase()
	{
		
	boolean flag =	  userDAO.isValidCredentials("sourabh", "sourabh");
	
	Assert.assertEquals("validateCredentialsTestCase", true , flag);;
	;;;;;;;;
	;;;;;;;;;
		
	}*/
	
	


@Test
public void createUserTestCase(){
	
	user.setId("SAI");
	user.setName("SAI");
	user.setAddress("BHOPAL");
	user.setPassword("SAI");
	user.setRole("ADMIN");
	user.setMobile("7389616986");
	
	user.setEmail("SAI.shrivastav@gmail");
   // user.setLastSeenTime(new Date());
    //user.setStatus('Y');
   

	boolean flag = userDAO.saveOrupdate(user);
	
	
	
	assertEquals("createUserTestCase",true,flag);
}
	
	@Ignore
	@Test
	public void getUserTestCase()
	{
		user =  userDAO.get("sourabh");
		
		assertEquals("getUserTestCase", null, user);
		
		
		
	}
	
	@Ignore
	@Test
	public void getAllUsersTestCase()
	{
		List<User> users=  userDAO.list();
		
		//select count(*) from c_user_detail
		assertEquals("getAllUsersTestCase", 3, users.size());
		
	}
	
	
	
	
	
	
	
	@Ignore	
@Test	
public void UpdateTestCase(){
	user.setId("niithhhh");
	user.setName("AsP");
	user.setAddress("Bolinj nakad");
	user.setPassword("niit");
	user.setRole("Alumni");
	user.setMobile("444444444");
	
	boolean flag = userDAO.save(user);
	
	
	
	assertEquals("UpdateTestCase",true,flag);
	
	
}
	@Ignore
@Test
public void AuthenticateTestcase()
{

	
	User flag = userDAO.authenticate("Aashi", "aashi");
	
	assertEquals("AuthenticateTestcase",null,flag);
	
	
}
	@Ignore
@Test
public void ListTestCase(){
	
	int size = userDAO.list().size();
	
	assertEquals("ListTestCase",9,size);
}
	@Ignore
@Test
public void getUserTestcase(){
	
	user = userDAO.get("BAHUBALI");
	
	assertEquals("getUserTestcase",null,user);
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	

}
