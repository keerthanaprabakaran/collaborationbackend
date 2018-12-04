package com.niit.collaboration.model;

import java.util.Date;

import oracle.jdbc.driver.Message;
public class OutputMessage extends MessageForum {
	 
	private Date time;
	
	public OutputMessage(Message message,Date time){
		super();
		this.time=time;
	}
	
	public Date getTime(){
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
