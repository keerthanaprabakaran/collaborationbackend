package com.niit.collaboration.DAO;

import java.util.List;

import com.niit.collaboration.model.Friend;
import com.niit.collaboration.model.User;

public interface FriendDAO {


	public List<Friend> listMyFriend(String userid);

	public Friend get(String friendID,String userid);

	public boolean save(Friend friend);

	public boolean update(Friend friend);

	public List<Friend> getNewFriendRequests(String userid);

	public boolean setOnline(String userid);

	public boolean setOffLine(String userid);

	// select * from Friend where userID=? status = 'N'
	public List<Friend> getRequestsSendByMe(String userid);

	
	public List<Friend> getMyFriends(String userID);
}















/*public List<Friend>  list();

public boolean save(Friend friend);
	
	public boolean update(Friend friend);
	
	public boolean delete(String id);

	public Friend get(String string);

	public boolean reject(String id);

	public List<Friend> setOnline(String id);

	public void setOffLine(String loggedInUserID);

	public List<Friend> getMyFriends(String loggedInUserID);

	public Friend get(String loggedInUSerID, String friendID);

	public List<Friend> getFriendsRequestsSendByMe(String loggedInUserID);

	public List<Friend> getNewFriendRequests(String loggedInUserID);

	public Object getfriendlist(String username);

	public void saveOrupdate(Friend online);*/