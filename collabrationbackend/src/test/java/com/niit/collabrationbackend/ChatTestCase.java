package com.niit.collabrationbackend;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.hibernate.id.IdentityGenerator.GetGeneratedKeysDelegate;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.DAO.ChatDAO;
import com.niit.collaboration.model.Chat;

import junit.framework.Assert;

public class ChatTestCase {

	
	@Autowired  static AnnotationConfigApplicationContext context;
	
	@Autowired  static Chat chat;
	
	@Autowired  static ChatDAO  chatDAO;
	
	
	
	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		chat = (Chat) context.getBean("chat");
		
		chatDAO = (ChatDAO) context.getBean("chatDAO");
		 
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
	public void createChatTestCase()
	{chat.setId(001);
	chat.setUserID("001");
	chat.setFriendID("002");
	chat.setDateTime(new Date(System.currentTimeMillis()));
	chat.setMessage("hello ");
	
	       boolean flag =	chatDAO.save(chat);
	       
	       assertEquals("createChatTestCase ",true, flag);
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
	
	
	
	
	
	
	
	
	
	
	
	


