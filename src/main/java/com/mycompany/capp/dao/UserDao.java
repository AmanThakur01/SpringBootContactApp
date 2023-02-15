package com.mycompany.capp.dao;

import java.util.List;

import com.mycompany.capp.domain.User;

public interface UserDao {
	public void save(User u);

	public void update(User u);

	public void delete(Integer uId);

	public User findById(Integer uId);

	public List<User> findAll();

	public List<User> findByProp(String fielName, Object value);

}
