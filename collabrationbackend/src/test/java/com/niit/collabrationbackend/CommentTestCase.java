package com.niit.collabrationbackend;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.DAO.CommentDAO;
import com.niit.collaboration.model.Comment;

import junit.framework.Assert;

public class CommentTestCase {

	
	@Autowired  static AnnotationConfigApplicationContext context;
	
	@Autowired  static Comment comment;
	
	@Autowired  static CommentDAO commentDAO;
	
	
	
	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		comment = (Comment) context.getBean("comment");
		
		commentDAO = (CommentDAO) context.getBean("commentDAO");
		 
	}
	
	
	/*//@Test
	
	public void validateCredentialsTestCase()
	{
		
	boolean flag =	  commentDAO.isValidCredentials("manish", "manish");
	
	Assert.assertEquals("validateCredentialsTestCase", true , flag);;
	;;;;;;;;
	;;;;;;;;;
		
	}
	*/
	
	//@Test
	public void createCommentTestCase(){
	comment.setUserId(null);
	comment.setDescription(null);
	comment.setForumId(null);
	comment.setCommented_date(null);
	comment.setErrorCode(null);

	       boolean flag =	commentDAO.save(comment);
	       
	       assertEquals("createCommentTestCase ",true, flag);
	}
	

	//@Test
	public void updateCommentTestCase()
	{
		comment.setId(null);
		comment.setTitle("manish");
		comment.setQualification(null);
		comment.setDateTime(null);
		comment.setDescription(null);
		comment.setStatus((Character) null);
		
	       boolean flag =	commentDAO.update(comment);
	       
	       assertEquals("createCommentTestCase ",true, flag);
	}
	
	
	@Test
	public void getCommentTestCase()
	{
		comment =  commentDAO.get("manish");
		
		assertEquals("getCommentTestCase", null, comment);
		
		
		
	}
	
	
	@Test
	public void getAllCommentsTestCase()
	{
		List<Comment> comments=  commentDAO.list();
		
		//select count(*) from c_comment_detail
		assertEquals("getAllCommentsTestCase", 28, comments.size());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
