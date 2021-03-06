package com.niit.collaboration.DAOImpl;


import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.DAO.ChatForumDAO;
import com.niit.collaboration.model.ChatForum;
@Transactional
@Repository("chatforumDAO")
public class ChatForumDAOimpl implements ChatForumDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<ChatForum> list(){
		String hql="from ChatForum c";
				Query query=sessionFactory.openSession().createQuery(hql);
		return query.list();
		
	}
	
	@Transactional
	public ChatForum get(String userID, Integer chatforumID) {
		String hql="select c from ChatForum c where c.userID="+"'"+userID+"'and c.id='"+chatforumID+"'";
		Query query=sessionFactory.openSession().createQuery(hql);
		
		return (ChatForum)query.list().get(0);
	}
	
	@Transactional
	public boolean update(ChatForum chatForum) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.update(chatForum);
			session.flush();
			return true;
		}catch(Exception e){
		e.printStackTrace();	
		return false;
		}
	}
	
	@Transactional	
	public boolean delete(String userID,BigDecimal chatforumID) {
		ChatForum chatForum=new ChatForum();
		chatForum.setId(userID);
		chatForum.setUserID(userID);
		Session session=sessionFactory.openSession();
		session.delete(chatForum);
		session.flush();
		return true;
	}
	
	@Transactional
	public boolean save(ChatForum chatForum){
		try{
			String hql="select c_chat_forum_sequence.nextval from dual";
			Query query=sessionFactory.getCurrentSession().createSQLQuery(hql);
	BigDecimal		maxID=(BigDecimal) query.uniqueResult();
			chatForum.setId(maxID.toString());
			Session session=sessionFactory.getCurrentSession();
			session.save(chatForum);
			session.flush();
		    return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public ChatForum getchatforum(ChatForum chatforum) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public boolean delete(ChatForum chatforum) {
		try {
			sessionFactory.getCurrentSession().delete(chatforum);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public ChatForum get(String id) {
		String hql = "from Forum where id='"+ id+"'" ;
		@SuppressWarnings("rawtypes")
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<ChatForum>list= query.list();
		
		if(list==null)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
	
    @Transactional 
    public boolean saveOrUpdate(ChatForum chatforum) {
	 try {
		   sessionFactory.getCurrentSession().saveOrUpdate(chatforum);
		   return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}

}

