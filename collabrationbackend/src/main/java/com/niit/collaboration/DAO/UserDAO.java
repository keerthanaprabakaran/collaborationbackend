package com.niit.collaboration.DAO;

import java.util.List;

import com.niit.collaboration.model.User;

public interface UserDAO {
	
	
	
public List<User> list();
	
	public List<User> notMyFriendList(String userID);

	public User get(String id, String password);

	public User get(String id);

	// public void saveOrUpdate(UserDetails UserDetails);

	public boolean save(User userDetailsDetails);

	public boolean update(User userDetailsDetails);

	public boolean delete(String id);

	public User authenticate(String id, String name);

	public void setOnline(String userID);

	public void setOffLine(String userID);

	public User isValidCredentials(String id, String pwd);
	public boolean saveOrupdate(User user);
	/*
	public User  get(String id);
	
	public List<User>  list();
	
	
	//If you are not using spring security,  you need to defin validate function
	public boolean isValidCredentials(String id, String password);
	
	
	public boolean save(User user);
	
	public boolean update(User user);
	
	public boolean delete(String id);

	public List<User> notMyFriendList(String loggedInUserID);

	public User authenticate(String id, String password);

	public void setOnline(String id);

	public void setOffLine(String loggedInUserID);
	*/

	//public com.niit.Collaboration.model.User authuser(String username, String password);

	//public com.niit.Collaboration.model.User oneuser(String id);

	public User validate(String id, String password);

}
