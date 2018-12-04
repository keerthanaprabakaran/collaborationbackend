package com.niit.collaboration.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.DAO.JobDAO;
import com.niit.collaboration.model.Job;
import com.niit.collaboration.model.User;



@Transactional
@Repository("jobDAO")
public class JobDAOimpl implements JobDAO {

	  private static final Logger log = LoggerFactory.getLogger(JobDAO.class);
private  SessionFactory  sessionFactory;
	
	
	public JobDAOimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	

	public Job get(String id) {
		 Job job = (Job) sessionFactory.getCurrentSession().get(Job.class, id);
		 
		 return job;
	}

	public List<Job> list() {
		 return sessionFactory.getCurrentSession().createQuery("from Job").list();
		
	}
/**\
 * If spring security not used
 */
	/*public boolean isValidCredentials(String id, String password) {
		Query query =  sessionFactory.getCurrentSession().createQuery("from Job where id =? and password = ? ");
		query.setString(0, id);
		query.setString(1, password);
		
		 if( query.uniqueResult() ==null)
		 {
			 return false;
		 }
		 else
		 {
			 return true;
		 }
		
	
	}*/
	@Transactional
	public boolean save(Job job) {
		try {
			sessionFactory.getCurrentSession().save(job);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
	}
/*	@Transactional
	public boolean update(Job job) {
	try {
		sessionFactory.getCurrentSession().update(job);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}*/
	
	@Transactional
	public boolean delete(String id)
	{
		log.debug("Starting of the method delete");
		log.debug("Trying to delte the record : " + id);
		try
		{
		
		sessionFactory.getCurrentSession().delete(get(id));
		log.debug("successfully delted the record :" + id);
		}catch(Exception e)
		{
			log.debug("record does not exist with the id " + id);
			return false;
			
		}
		log.debug("Ending of the method delete");
		return true;
	}
	
	
	@Transactional
	public boolean saveOrupdate(Job job) {
		
		log.debug("Starting of the Save Method");
		
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(job);
			
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
				log.debug("Ending of the Save Method");
				return false;
			}
		}




	public boolean updatejob(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}




	public Job getJobById(String id) {
 Job job = (Job) sessionFactory.getCurrentSession().get(Job.class, id);
		 
		 return job;
	}
	
}
