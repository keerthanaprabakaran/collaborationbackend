package com.niit.collaboration.DAO;

import java.util.List;

import com.niit.collaboration.model.Comment;
import com.niit.collaboration.model.User;

public interface CommentDAO {

	public List<Comment>  list();
	
public boolean save(Comment comment);
	
	public boolean update(Comment comment);
	
	public boolean delete(String id);

	public Comment get(String string);
}
