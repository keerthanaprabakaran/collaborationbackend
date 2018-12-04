package com.niit.collaboration.DAO;

import java.math.BigDecimal;
import java.util.List;

import com.niit.collaboration.model.ChatForum;

public interface ChatForumDAO {


	public List<ChatForum> list();
	public ChatForum get(String userID, Integer chatforumID);
	public boolean update(ChatForum chatForum) ;
	public boolean delete(String userID,BigDecimal commentID);
	public boolean save(ChatForum chatForum);
	public ChatForum getchatforum(ChatForum chatforum);
	public boolean delete(ChatForum chatforum);
	public ChatForum get(String id);
	public boolean saveOrUpdate(ChatForum chatforum);
}
