package com.niit.collaboration.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "C_JOB_APPLICATION")
@Component
public class JobApplication extends BaseDomain{


	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String string) {
		this.jobID = string;
	}
	public Date getDateApplied() {
		return dateApplied;
	}
	public void setDateApplied(Date dateApplied) {
		this.dateApplied = dateApplied;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	@Id
	private Integer id;
	@Column(name="USER_ID")
	private String user_id;
	
	@Column(name="job_id")
	private String jobID;
	
	@Column(name="date_applied")
	private Date dateApplied;
	private String remarks;
	private char status;//S->Select; R->Reject; C->Call For Inerview
	public void setDate_time(Date today) {
	   this.setDate_time(today);
		
	}
	}