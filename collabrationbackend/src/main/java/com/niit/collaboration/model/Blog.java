package com.niit.collaboration.model;

import java.math.BigDecimal;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.type.ClobType;
import org.springframework.stereotype.Component;


@Entity
@Table(name="C_BLOG")
@Component
public class Blog extends BaseDomain {

	@Id
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		Userid = userid;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date date) {
		this.datetime = date;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	private String Title;
	
	@Column(name="User_id")
	private String Userid;
	@Column(name="date_time")
	private Date datetime;
	private char status;
	private String reason;
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	}
	

