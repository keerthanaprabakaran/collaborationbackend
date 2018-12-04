package com.niit.collaboration.DAOImpl;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.DAO.BlogDAO;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.User;
@Transactional
@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	public List<Blog> list() {
		return sessionFactory.getCurrentSession().createQuery("from Blog").list();
	}

	public Blog getBlogById(int id) {
		Blog blog = (Blog) sessionFactory.getCurrentSession().get(Blog.class, id);
		return blog;
	}

	public boolean save(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	


	@Transactional
	public boolean saveOrupdate(Blog blog) {
		
		//log.debug("Starting of the Save Method");
		
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(blog);
			//	log.info("id"+blog.getId());
				//log.info("name"+user.getName());
			//	log.info("address"+user.getPassword());
			//	log.info("id"+user.getRole());
			//	log.info("id"+user.getAddress());
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
				//log.debug("Ending of the Save Method");
				return false;
			}
		}
}

	
	/*@Transactional
	private Integer getMaxId()
	{
		String hql="select c_blog_sequence.nextval from dual";
	Query query=sessionFactory.getCurrentSession().createSQLQuery(hql);
	Integer maxID;
     try{
			maxID=(Integer) query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return 100;
		}return maxID+1;
	}
	
	@Transactional
	public List<Blog> list(){
		String hql="from Blog";
				Query query=sessionFactory.openSession().createQuery(hql);
		return query.list();
		
	}
	
	
	@Transactional
	public List<Blog> userbloglist(String userID){
		String hql="from Blog b where b.userID="+"'"+userID+"'";
				Query query=sessionFactory.openSession().createQuery(hql);
		return query.list();
		
	}
	
	@Transactional
	public Blog get(String userID, Integer blogID) {
		String hql="select b from Blog b where b.userID="+"'"+userID+"'and b.id='"+blogID+"'";
		Query query=sessionFactory.openSession().createQuery(hql);
		System.out.println("blogid="+blogID);
		System.out.println("userid="+userID);
		return (Blog)query.list().get(0);
	}

	@Transactional
	public boolean update(Blog blog) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.update(blog);
			session.flush();
			return true;
		}catch(Exception e){
		e.printStackTrace();	
		return false;
		}
	}
		
	@Transactional	
	public boolean delete(String userID, BigDecimal blogID) {
		Blog blog=new Blog();
		blog.setId(blogID);
		blog.setUserid(userID);
		Session session=sessionFactory.openSession();
		session.delete(blog);
		session.flush();
		return true;
	}
	@Transactional
	public boolean save(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean save(Blog blog){
		
		try{
			String hql="select c_blog_sequence.nextval from dual";
			Query query=sessionFactory.getCurrentSession().createSQLQuery(hql);
	BigDecimal		maxID=(BigDecimal) query.uniqueResult();
			blog.setId(maxID);
			Session session=sessionFactory.getCurrentSession();
			session.save(blog);
			session.flush();
		    return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public Blog getBlogById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}*/

/*package com.niit.Collaboration.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.niit.Collaboration.DAO.BlogDAO;
import com.niit.Collaboration.model.Blog;

@Transactional
@Repository("blogDAO")
public class BlogDAOimpl {

	  private static Logger log = LoggerFactory.getLogger(BlogDAO.class);
private  SessionFactory  sessionFactory;
	
   
	public BlogDAOimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	
@Transactional
	public Blog get(String id) {
		 Blog blog = (Blog) sessionFactory.getCurrentSession().get(Blog.class, id);
		 
		 return blog;
	}

	public List<Blog> list() {
		 return sessionFactory.getCurrentSession().createQuery("from Blog").list();
		
	}
*//**\
 * If spring security not used
 *//*
	public boolean isValidCredentials(String id, String password) {
		Query query =  sessionFactory.getCurrentSession().createQuery("from Blog where id =? and password = ? ");
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
		
	
	}
	@Transactional
	public boolean save(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
	}
	@Transactional
	public boolean update(Blog blog) {
	try {
		sessionFactory.getCurrentSession().update(blog);
		return true;
	} catch (HibernateException e) {
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
}
*/