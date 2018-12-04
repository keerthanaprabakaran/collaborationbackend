package com.niit.collabrationbackend;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.DAO.BlogDAO;
import com.niit.collaboration.DAO.UserDAO;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.User;

import junit.framework.Assert;

public class UploadFileTestCase {

	
	@Autowired  static AnnotationConfigApplicationContext context;
	
	@Autowired  static Blog blog;
	
	@Autowired  static BlogDAO  blogDAO;
	
	
	
	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		blog = (Blog) context.getBean("blog");
		
		blogDAO = (BlogDAO) context.getBean("blogDAO");
		 
	}
	
	/*@Test
	
	public void validateCredentialsTestCase()
	{
		
	boolean flag =	  blogDAO.isValidCredentials("manish", "manish");
	
	Assert.assertEquals("validateCredentialsTestCase", true , flag);;
	;;;;;;;;
	;;;;;;;;;
		
	}
	*/
	
	@Test
	public void createBlogTestCase()
	{
		blog.setId(1);
		blog.setUserid("Aashi");
		blog.setTitle("FUN");
		blog.setDatetime(new Date());
	    blog.setStatus('Y');
	    blog.setReason("this is for status");
	    blog.setDescription("Entertainment blog");
		boolean flag =	blogDAO.saveOrupdate(blog);
	       
	       assertEquals("createBlogTestCase ",true, flag);
	}
	
	/*public void createBlog() {
		blog.setId("b005");
		
		blog.setTitle("Test");
		blog.setUserid("u001");
		boolean flag = blogDAO.save(blog);
		Assert.assertEquals("createBlog", true, flag);

	}

	public void updateBlog() {
		String var = "Hello world";
		// java.sql.Blob blob =
		// org.hibernate.Hibernate.createBlob(var.getBytes());
		blog.setId("b001");
		blog.setTitle("Testss");
		blog.setUserid("u001");
		blog.setReason("abcdefg");
		blog.setStatus("Y");
		blog.setDescription("Testvxcvxcvcvxcv");

		boolean flags = blogDAO.update(blog);
		Assert.assertEquals("updateBlog", true, flags);
	}

	@Test
	public void listBlogs() {
		blog = blogDAO.getBlogById("b0041");
		Assert.assertEquals("listBlogs", null, blog);
	}

	@Test
	public void deleteBlog() {
		blog = blogDAO.getBlogById("b004");
		boolean blogs = blogDAO.delete(blog);
		Assert.assertEquals("deleteBlog", true, blogs);
	}*/
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


