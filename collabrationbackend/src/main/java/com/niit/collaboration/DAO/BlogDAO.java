package com.niit.collaboration.DAO;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.util.MultiValueMap;

import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.User;

public interface BlogDAO {



	public List<Blog> list();
	
	public Blog getBlogById(int id);
	
	public boolean save(Blog blog);
	
	public boolean update(Blog blog);
	
	public boolean delete(Blog blog);
	public boolean saveOrupdate(Blog blog);

	
}

































/*public List<Blog>  list();

public boolean save(Blog blog);

public boolean update(Blog blog);

public boolean delete(String id);

public Blog get(String string);

public boolean reject(String id);

public boolean isValidCredentials(String string, String string2);

public MultiValueMap userbloglist(String id);

public Blog get(String uid, int parseInt);

public Blog getBlogById(String id)*/;

/*	public List<Blog> list();
public Blog get(String userID, Integer blogID);
public boolean update(Blog blog);
public boolean delete(String userID, BigDecimal blogID);
public boolean save(Blog blog);
public List<Blog> userbloglist(String userID);
public Blog getBlogById(String id);*/