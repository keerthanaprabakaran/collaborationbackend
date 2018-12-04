package com.niit.collaboration.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.DAO.EventDAO;
import com.niit.collaboration.model.Blog;

import antlr.debug.Event;
@Transactional
@Repository("eventDAO")
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean save(Event event) {
		try {
			sessionFactory.getCurrentSession().save(event);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<Event> listEvent() {
		return sessionFactory.getCurrentSession().createQuery("from Event").list();
	}
	
	private Integer getMaxId() {

		String hql = "select max(id) from Event";
		Query query = sessionFactory.openSession().createQuery(hql);
		Integer maxID;
		try {
			
			maxID = (Integer) query.uniqueResult();
			if (maxID == null) {
				maxID = 100;
			}
		} catch (NullPointerException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 100;
		}

		return maxID;

	}

	public boolean update(Event event) {
		try {
			sessionFactory.getCurrentSession().update(event);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public Event getEventById(String event_id) {
		Event event = (Event) sessionFactory.getCurrentSession().createQuery("from Event where id ='"+event_id+ "' ").uniqueResult();
		return event;
	}
	@Transactional
	public boolean saveOrupdate(Event  event) {
		
	
		
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(event);
			
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
				//log.debug("Ending of the Save Method");
				return false;
			}
		}

	public boolean saveOrupdate(com.niit.collaboration.model.Event event) {
		// TODO Auto-generated method stub
		return false;
	}

}
