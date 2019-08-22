package com.gl.dao;

import java.util.List;

import com.gl.model.Person;

public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
}
