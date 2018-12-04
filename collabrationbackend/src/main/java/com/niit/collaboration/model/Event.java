package com.niit.collaboration.model;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Table(name="C_EVENTS")
@Entity
public class Event extends BaseDomain{

	@Id
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "VENUE")
	private String venue;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public Blob getData() {
		return data;
	}

	public void setData(Blob data) {
		this.data = data;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Column(name = "EVENT_DATE")
	private Date event_date;
	
	@Column(name = "FILE_NAME")
	private String file_name;
	
	  									//to store some image files, Large Object
	@Column(name = "FILE_DATA")
	private Blob data;
	
	@Column(name = "USER_ID")
	private String user_id;
	
}