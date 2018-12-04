package com.niit.collabrationbackend;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.DAO.EventDAO;
import com.niit.collaboration.model.Event;

public class EventTestCase {

	@Autowired
	private static Event event;
	
	@Autowired
	private static EventDAO eventDAO;
	
	@BeforeClass
	public static void init(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		event = (Event) context.getBean("event");
		
		eventDAO = (EventDAO) context.getBean("eventDAO");
		
		
	}
	@Test
	public void createEventTestCase(){
		event.setId(2);
		event.setName("Live Time Achievment");
		event.setDescription("Apj Abdul Kalam sir");
		event.setUser_id("Aashi");
		event.setVenue("Jalandar");
	
		event.setFile_name("Bussiness");
		
		
		boolean flag = eventDAO.saveOrupdate(event);
		assertEquals("createEventTestCase",true,flag);
	}
	

}