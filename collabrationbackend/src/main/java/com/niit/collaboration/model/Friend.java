package com.niit.collaboration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "C_FRIEND")
@Component
public class Friend extends BaseDomain{

	@Id
	private int id;
	
	@Column(name="USER_ID")
	private String user_id;
	
	 @Column(name="FRIEND_ID")
	private String friend_id;
	
	private char status;
	
	@Column(name="is_online")
	private char isOnline;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*public String getUser_id() {
		return user_id;
	}

	public void setUserid(String userID) {
		this.user_id= userID;
	}*/

	/*public String getFriendID() {
		return friend_id;
	}

	public void setFriendID(String friendID) {
		this.friend_id= friendID;
	}*/

	public char getStatus() {
		return status;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFriend_id() {
		return friend_id;
	}

	public void setFriend_id(String friend_id) {
		this.friend_id = friend_id;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public char getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(char isOnline) {
		this.isOnline = isOnline;
	}

	public void setIsOnline(String string) {
		// TODO Auto-generated method stub
		
	}


		

	
	
}