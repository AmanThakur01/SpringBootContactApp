package com.mycompany.capp.dao;

import java.util.List;

import com.mycompany.capp.domain.Contact;

public interface ContactDao {
	public void save(Contact c);

	public void update(Contact c);

	public void delete(Integer cId);

	public Contact findById(Integer cId);

	public List<Contact> findAll();

	public List<Contact> findByProp(String fielName, Object value);
}
