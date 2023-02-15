package com.mycompany.capp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.capp.domain.Contact;

@Repository
public class ContactDaoImpl implements ContactDao {

	@Override
	public void save(Contact c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Contact c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer cId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Contact findById(Integer cId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> findByProp(String fielName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
