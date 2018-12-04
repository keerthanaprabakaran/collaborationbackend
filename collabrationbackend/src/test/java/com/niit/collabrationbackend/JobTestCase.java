package com.niit.collabrationbackend;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.DAO.JobDAO;
import com.niit.collaboration.model.Job;

import junit.framework.Assert;

public class JobTestCase {

	
	@Autowired  static AnnotationConfigApplicationContext context;
	
	@Autowired  static Job job;
	
	@Autowired  static JobDAO  jobDAO;
	
	
	
	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		job = (Job) context.getBean("job");
		
		jobDAO = (JobDAO) context.getBean("jobDAO");
		 
	}
	
	
	//@Test
	

	
	@Test
	public void createJobTestCase()
	{
	job.setId("1");
	job.setTitle("Software vacancy");
	job.setQualification("b.e/b.tech");
	job.setDate_time(new Date());
	job.setDescription("SKills in Software developement");
	job.setStatus("vacant");
	
	       boolean flag =	jobDAO.save(job);
	       
	       assertEquals("createJobTestCase ",true, flag);
	}
	
	/*
	//@Test
	public void updateJobTestCase()
	{
		job.setId(0);
		job.setTitle("manish");
		job.setQualification(null);
		job.setDateTime(null);
		job.setDescription(null);
		job.setStatus((Character) null);
		
	       boolean flag =	jobDAO.updatejob(job);
	       
	       assertEquals("createJobTestCase ",true, flag);
	}
	
	
	@Test
	public void getJobTestCase()
	{
		job =  jobDAO.get("manish");
		
		assertEquals("getJobTestCase", null, job);
		
		
		
	}
	
	
	@Test
	public void getAllJobsTestCase()
	{
		List<Job> jobs=  jobDAO.list();
		
		//select count(*) from c_job_detail
		assertEquals("getAllJobsTestCase", 28, jobs.size());
	}
	
	
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
