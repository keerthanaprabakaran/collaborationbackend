package com.niit.collaboration.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.collaboration.DAO.FriendDAO;
import com.niit.collaboration.model.Friend;



@Transactional
@Repository("friendDAO")
public class FriendDAOimpl implements FriendDAO {

	@Autowired
	private SessionFactory sessionFactory;


	private static final Logger log = LoggerFactory.getLogger(UserDAOImpl.class);

	private Integer getMaxId() {

		String hql = "select max(id) from Friend";
		Query query = sessionFactory.openSession().createQuery(hql);
		Integer maxID;
		try {
			log.debug("Enter into calculate MaxID");
			maxID = (Integer) query.uniqueResult();
			if (maxID == null) {
				maxID = 100;
			}
		} catch (NullPointerException e) {
			log.debug("Enter In to MAXID Exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 100;
		}

		return maxID;

	}

	public List<Friend> listMyFriend(String user_id) {
		String hql1 = "select friend_id  from Friend where user_id='" + user_id+ "' and status = 'Y' ";

		/* + " union  " + */

		String hql2 = "select user_id from Friend where friend_id='" + user_id+ "' and status = 'Y'";

		log.debug("getMyFriends hql1 : " + hql1);
		log.debug("getMyFriends hql2 : " + hql2);

		List<Friend> list1 = sessionFactory.openSession().createQuery(hql1).list();
		List<Friend> list2 = sessionFactory.openSession().createQuery(hql2).list();

		list1.addAll(list2);
log.debug("array count"+list1.size());
		return list1;
	}

	public Friend get(String friend_id,String user_id) {
		String hql = "from Friend where user_id=" + "'" + user_id+ "' and friend_id= '" + friend_id + "' and status= 'R' ";

		log.debug("hql: " + hql);
		Query query = sessionFactory.openSession().createQuery(hql);

		return (Friend) query.uniqueResult();
	}
	@Transactional
	public boolean save(Friend friend) {
		try {
			// log.debug("*********************Previous id " + getMaxId());
			friend.setId(getMaxId() + 1);
			log.debug("***********************generated id:" + getMaxId());
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch (Exception e) {
			log.debug("Enter into SAVE EXCEPTION");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean update(Friend friend) {
		try {
			log.debug("Starting of the method update");
			log.debug("user ID : " + friend.getUser_id() + " Friend id :" + friend.getFriend_id());
			log.debug("user ID : " + friend.getUser_id() + " Friend id :" + friend.getFriend_id());
			sessionFactory.getCurrentSession().update(friend);
			log.debug("Successfully updated");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("Not able to update the status");
			return false;
		}
	}
	@Transactional
	public List<Friend> getNewFriendRequests(String user_id) {
		String hql = "select user_id from Friend where friend_id=" + "'" + user_id+ "' and status ='" + "R'";

		log.debug(hql);
		 return  sessionFactory.openSession().createQuery(hql).list();
	}

	public boolean setOnline(String userid) {
		log.debug("Starting of the metnod setOnline"+userid);
		
		//String hql = " UPDATE Friend	SET isOnline = 'Y' where friend_id='" + userid+ "'";
		
		try {
			String hql = " UPDATE Friend	SET is_online = 'Y' where friend_id= ?";
			
			
			
			
			log.debug("hql: " + hql);
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setString(0, userid);
			
			
			query.executeUpdate();
			log.debug("Ending of the metnod setOnline"+query);
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	@Transactional
	public boolean setOffLine(String userid) {
		try {
			log.debug("Starting of the metnod setOffLine");
			String hql = " UPDATE Friend	SET is_online = 'N' where friend_id='" + userid+ "'";
			log.debug("hql: " + hql);
			Query query = sessionFactory.openSession().createQuery(hql);
			query.executeUpdate();
			log.debug("Ending of the metnod setOffLine");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	@Transactional
	public List<Friend> getRequestsSendByMe(String userid) {
		String hql = "select friend_id from Friend where user_id=" + "'" + userid+ "' and status ='" + "R'";

		log.debug(hql);
		return  sessionFactory.openSession().createQuery("From Friend").list();
	}


	@Transactional
	public List<Friend> getMyFriends(String user_id) {
		String hql1="select f from Friend f where f.userID='"+user_id+"'and f.status='A'";
		String hql2="select f from Friend f where f.friendID='"+user_id+"'and f.status='A'";
		Query query1=sessionFactory.openSession().createQuery(hql1);
		Query query2=sessionFactory.openSession().createQuery(hql2);
		List<Friend> list1=(List<Friend>)query1.list();
		List<Friend> list2=(List<Friend>)query2.list();
		list1.addAll(list2);
		return list1;
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

/*
	  private static Logger log = LoggerFactory.getLogger(JobDAO.class);
private  SessionFactory  sessionFactory;
	
	
	public FriendDAOimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Autowired
	private SessionFactory sessionFactory;
	public FriendDAOImpl()
	{
		
	}
	@Autowired
	public FriendDAOImpl(SessionFactory sessionFactory)
	
	{
		this.sessionFactory=sessionFactory;
	}
	
	private BigDecimal getMaxId()
	{
		String hql="select c_friend_sequence.nextval from dual";
	Query query=sessionFactory.getCurrentSession().createSQLQuery(hql);
	BigDecimal maxID=null;
     try{
		maxID=(BigDecimal)query.list().get(0);
		log.debug("maxid is "+maxID);
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
			
		}return maxID;
	}
	
	@Transactional
	public List<Friend> getMyFriends(String userID) {
		String hql1="select f from Friend f where f.userID='"+userID+"'and f.status='A'";
		String hql2="select f from Friend f where f.friendID='"+userID+"'and f.status='A'";
		Query query1=sessionFactory.openSession().createQuery(hql1);
		Query query2=sessionFactory.openSession().createQuery(hql2);
		List<Friend> list1=(List<Friend>)query1.list();
		List<Friend> list2=(List<Friend>)query2.list();
		list1.addAll(list2);
		return list1;
	}
	

	@Transactional
	public Friend get(String userID, String friendID) {
		log.debug(userID);
		log.debug(friendID);
		String hql="select f from Friend f where f.userID="+"'"+userID+"'and f.friendID='"+friendID+"'";
		Query query=sessionFactory.openSession().createQuery(hql);
		log.debug("reached hear");
		if(query.list().size()==0)
		{
	  return null;
		}
		else
		{
		Friend f=(Friend)query.list().get(0);
		System.out.println(f.getId());
		return f;
	
		}
		
		
		
	}

	@Transactional
	public boolean update(Friend friend) {
		try{
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}catch(Exception e){
		e.printStackTrace();	
		return false;
		}
	}
		
	@Transactional	
	public void delete(String userID, String friendID) {
		Friend friend=new Friend();
		friend.setFriendID(friendID);
		friend.setUserID(userID);
		sessionFactory.openSession().delete(friend);
	}

	@Transactional
	public List<Friend> getNewFriendRequests(String userID) {
		String hql="select f.friendID from Friend f where f.userID="+"'"+userID+"'and f.status='"+"N'";
		Query query=sessionFactory.openSession().createQuery(hql);
		List<Friend> list=(List<Friend>)query.list();
		return list;
	}

	@Transactional
	public void setOnline(String friendID) {
		try{
			String hql="UPDATE Friend SET isOnline='Y' where friendID='"+friendID+"'";
			//log.debug("hql:"+hql);
			 Query query=sessionFactory.getCurrentSession().createQuery(hql);
				query.executeUpdate();
				
		}
		catch(Exception e)
		{
			
			System.out.println("Error  from friend "+e);
		}
		//log.debug("Startinh of the method setOnline");
			//log.debug("Ending of the method method setOnline");
		
	}

	@Transactional
	public void setOffLine(String friendID) {
		//log.debug("Startinh of the method setOffline");
				String hql="UPDATE Friend SET isOnline='N' where friendID='"+friendID+"'";
				//log.debug("hql:"+hql);
				 Query query=sessionFactory.getCurrentSession().createQuery(hql);
					query.executeUpdate();
					//log.debug("Ending of the method method setOffline");		
	}
	
	@Transactional
	public boolean save(Friend friend){
		try{
			friend.setId(getMaxId().intValue());
			sessionFactory.getCurrentSession().save(friend);
		    return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	@Transactional
	public boolean save(Friend friend) {
		try {
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
	}
	
	@Transactional
public List<Friend> getFriendsRequestsSendByMe(String friendid)
{
	String hql="select f.status  from Friend f where friendID=' "+friendid+"'";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
}

	public List<Friend> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Friend get(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean reject(String id) {
		// TODO Auto-generated method stub
		return false;
	}


@Transactional
public List<Friend> setonline(String uid) {
	String hql="from Friend where friendid='"+uid+"'";
	@SuppressWarnings("rawtypes")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Friend> list=query.list();
	return list;
}
	public Object getfriendlist(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveOrupdate(Friend online) {
		// TODO Auto-generated method stub
		
	}

	public List<Friend> setOnline(String id) {
		// TODO Auto-generated method stub
		return null;
	}*/
