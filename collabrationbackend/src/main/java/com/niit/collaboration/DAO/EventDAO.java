package com.niit.collaboration.DAO;

import java.util.List;

import antlr.debug.Event;

public interface EventDAO {

	public boolean save(Event event);
	public boolean update(Event event);
	public Event getEventById(String event_id);
	public List<Event> listEvent();
	public boolean saveOrupdate(com.niit.collaboration.model.Event event);
}

