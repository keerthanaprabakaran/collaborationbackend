package com.niit.collaboration.DAO;

import java.util.List;

import com.niit.collaboration.model.Job;


public interface JobDAO {

	
	
	
	
public boolean save(Job job);


	
	public boolean updatejob(Job job);
	
	//public boolean updatejob(JobApplication jobApplication);
	// select * from JobApplication where userId=?
	//public List<Job>  getMyAppliedJobs(String userID);
	
	//public JobApplication getJobApplication(String userID,Long jobID);
	
	//public JobApplication getJobApplication(Long jobID);

	public Job get(String string);

	public List<Job> list();
	public boolean saveOrupdate(Job job);



	public Job getJobById(String id);

	
	
	
}
