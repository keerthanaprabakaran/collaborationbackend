package com.niit.collabrationbackend;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.collaboration.DAO.ChatForumDAO;

import com.niit.collaboration.model.ChatForum;

public class ChatForumTestCase {

	
	@Autowired  static AnnotationConfigApplicationContext context;
	
	@Autowired  static ChatForum chatforum;
	
	@Autowired  static ChatForumDAO  chatforumDAO;
	
	
	
	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		chatforum = (ChatForum) context.getBean("chatforum");
		
		 chatforumDAO = (ChatForumDAO) context.getBean("chatforumDAO");
		 
	}
	
	
	/*
	@Test
	
	public void validateCredentialsTestCase()
	{
		
	boolean flag =	  chatDAO.isValidCredentials("manish", "manish");
	
	Assert.assertEquals("validateCredentialsTestCase", true , flag);;
	;;;;;;;;
	;;;;;;;;;
		
	}*/
	
	
	@Test
	public void createChatForumTestCase()
	{
    chatforum.setId("01");
	chatforum.setUserID("001");
	chatforum.setForumName("Niit");
	chatforum.setCreatedDate(new Date());
	chatforum.setMessage("hello");
	      
	boolean flag =	chatforumDAO.saveOrUpdate(chatforum);
	       
	       assertEquals("createChatForumTestCase ",true, flag);
	}
	
	/*
	@Test
	public void updateChatTestCase()
	
		{
		chat.setId(001);
		chat.setUserID("001");
		chat.setFriendID("002");
		chat.setDateTime(new Date(System.currentTimeMillis()));
		chat.setMessage("bbye ");
		
		
	       boolean flag =	chatDAO.update(chat);
	          
	       assertEquals("createChatTestCase ",true, flag);
	}
	
	*/
	/*@Test
	public void getChatTestCase()
	{
		chat =  chatDAO.get("sourabh");
		
		assertEquals("getChatTestCase", null, chat);
		
		
		
	}
	
	
	@Test
	public void getAllChatsTestCase()
	{
		List<Chat> chats=  chatDAO.list();
		
		//select count(*) from c_chat_detail
		assertEquals("getAllChatsTestCase", 28, chats.size());
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
	
	
	
	
	
	
	
	
	
	
	
	


