package com.niit.collaboration.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.DAO.JobApplicationDAO;
import com.niit.collaboration.model.JobApplication;
import com.niit.collaboration.model.User;
@Repository("jobApplicationDAO")
@Transactional
public class JobApplicationDAOImpl implements JobApplicationDAO{

	@Autowired
	private SessionFactory sessionFactory;
	public List<JobApplication> list() {
		return sessionFactory.getCurrentSession().createQuery("from JobApplication").list(); 
	}

	public List<JobApplication> getList(String user_id) {
		return sessionFactory.getCurrentSession().createQuery("from JobApplication where user_id='"+user_id+"'  ").list();
	}

	public boolean save(JobApplication jobApplication) {
		try {
			//jobApplication.setId(getMaxId() + 1);
			sessionFactory.getCurrentSession().save(jobApplication);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public JobApplication getApplicationById(Integer id) {
		
	JobApplication	jobApplication = (JobApplication) sessionFactory.getCurrentSession().get(JobApplication.class, id);
	return jobApplication;
	}
	
	private Integer getMaxId() {
		

		String hql = "select max(id) from JobApplication";
		Query query = sessionFactory.openSession().createQuery(hql);
		Integer maxID;
		try {
			maxID = (Integer) query.uniqueResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 100;
		}
		
		return maxID;
	}
	
	@Transactional
	public boolean saveOrupdate(JobApplication jobApplication) {
		try {
			jobApplication.setId(getMaxId() + 1);
			sessionFactory.getCurrentSession().saveOrUpdate(jobApplication);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

}

}