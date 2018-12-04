package com.niit.collaboration.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "C_USER_DETAIL")
@Component
public class User extends BaseDomain{

	@Id
	private String id;

	private String name;

	private String email;

	private String address;

	private String mobile;
	
	//{{"role":"Employee", "role":"Admin"}
	private String role;
	
	private  String password;
	
	
	
	/*private String dob;
	
	public String getDob() {
		return dob;
	}
	public void setDob(String string) {
		this.dob = string;
	}*/

	/*private char status;
	
	private String reason;
	
	@Column(name = "LAST_SEEN_TIME")
	private Date lastSeenTime;

	public String ErrorCode;
	
	
	
	
	
	public Date getLastSeenTime() {
		return lastSeenTime;
	}
	public void setLastSeenTime(Date lastSeenTime) {
		this.lastSeenTime = lastSeenTime;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}*/
	/*public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;*/
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	//It will not serialize / store in file

	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
