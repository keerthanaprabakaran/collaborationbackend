package com.niit.collaboration.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.DAO.UserDAO;
import com.niit.collaboration.model.User;






@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

	
	 private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
		 
		@Autowired(required=true)
		private SessionFactory sessionFactory;


		public UserDAOImpl(SessionFactory sessionFactory) {
			try {
				this.sessionFactory = sessionFactory;
			} catch (Exception e) {
				log.error(" Unable to connect to db");
				e.printStackTrace();
			}
		}

		@Transactional
		public List<User> list() {
			 return sessionFactory.getCurrentSession().createQuery("from User").list();

		}
		
	/*	@Transactional
		public List<User> list() {
			String hql = "from User";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();
		}
*/
		@Transactional
		public boolean update(User user) {
			log.debug("->->Starting of the method update");
			try {
				sessionFactory.getCurrentSession().update(user);
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		
		@Transactional
		public boolean save(User user) {
			log.debug("->->Starting of the method save");
			try {
				sessionFactory.getCurrentSession().save(user);
				log.debug("->->User is created successfully");
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		
			


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
		public User get(String id, String password) {
			log.debug("->->Starting of the method get");
			log.debug("->->id : " + id);
			log.debug("->->password : " + password);
			String hql = "from User where id=" + "'"+ id+"'  and password = "
					+"'" + password + "'";
		   return getUser(hql);
		}
		
	
		public User get(String id) {
			 User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
			 
			 return user;
		}
		
		private User getUser(String hql)
		{
			log.debug("->->Starting of the method getUser");
			log.debug("->->hql : " +hql);
	        Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<User> list = (List<User>) query.list();
			
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			}
			return null;
		}
		
		@Transactional
		public User authenticate(String id, String password) {
			log.debug("->->Starting of the method isValidUserDetails");
			String hql = "from User where id= '" + id + "' and " + " password ='" + password+"'";
			
			log.debug("Query is : "+hql);
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<User> list = (List<User>) query.list();
			
			if (list != null && !list.isEmpty()) {
				return list.get(0);
			}
			
			return null;
		}


		@Transactional
		public void setOnline(String userID) {
			log.debug("Starting of the metnod setOnline");
			String hql =" UPDATE User	SET isOnline = 'Y' where id='" +  userID + "'" ;
			  log.debug("hql: " + hql);
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.executeUpdate();
			log.debug("Ending of the metnod setOnline");
			
		}
		
		@Transactional
		public void setOffLine(String userID) {
			log.debug("Starting of the metnod setOffLine");
			String hql =" UPDATE User	SET isOnline = 'N' where id='" +  userID + "'" ;
			  log.debug("hql: " + hql);
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.executeUpdate();
			log.debug("Ending of the metnod setOffLine");
			
		}

		@Transactional
		public List<User> notMyFriendList(String userID) {
			String hql = "from User where id not in( SELECT friendID from"
					+ " Friend  where userID ='"+userID + ""
					+ "' OR friendID= '" + userID+ "')";
			log.debug("Query:"+ hql);
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		}

		@Transactional
		public boolean saveOrupdate(User user) {
			
			log.debug("Starting of the Save Method");
			
				try {
					sessionFactory.getCurrentSession().saveOrUpdate(user);
					log.info("id"+user.getId());
					log.info("name"+user.getName());
					log.info("address"+user.getPassword());
					log.info("id"+user.getRole());
					log.info("id"+user.getAddress());
					return true;
				} catch (HibernateException e) {
					e.printStackTrace();
					log.debug("Ending of the Save Method");
					return false;
				}
			}


		public User isValidCredentials(String id, String password) {
			User user =  (User) sessionFactory.getCurrentSession().createQuery("from User where id ='"+id+"' and password = '"+password+"' ").uniqueResult();
		System.out.println("the given id and password is"+id  +password);
		return user;

		}
/*
		public User authuser(String username, String password) {
			// TODO Auto-generated method stub
			return null;
		}*/

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Transactional
		public User oneuser(String id) {
			String hql = "from Users where id= " + "'" + id + "'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);

			List<User> list = query.list();

			if (list.isEmpty()) {
				return null;
			} else {
				return list.get(0);
			}
		}


		@Transactional
		public User validate(String id,String password){
			//String hql="select * from c_user_detail where id='"+id+"' and password='"+password+"'";
			String hql=" from User u " ;
					
			//User user=(User) sessionFactory.getCurrentSession().get(User.class, id);
			            /* sessionFactory.getCurrentSession().create
			List<User> list=query.list();
		if(list.size()==0)
		{
			return null;
		}*/System.out.println("inside validation1");
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<User> users=query.list();
		for(User u : users)
		{
			System.out.println("id is "+u.getId()+"  pass word "+u.getPassword());
			
		}
			for(User u : users)
			{
				System.out.println("id is "+u.getId()+"  pass word "+u.getPassword());
				if(u.getId().equals(id) && u.getPassword().equals(password.trim()))
				{
					return u;
				}
			}
			    /*if(query.list().size()==0)
			    {
			    	System.out.println("inside validation2");
			    	return null;
			    }
			    else
			    {
			    	System.out.println("inside validation3");
			    	return (User)query.list().get(0); }
		}*/
			return null;
		}
			
	}


		
		
		



