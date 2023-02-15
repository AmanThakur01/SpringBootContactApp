package com.mycompany.capp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.capp.domain.User;
@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public void save(User u) {
		String  sql = "INSERT INTO user(`userId`, `name`, `phone`, `email`, `address`, `loginName`, `password`, `role`, `loginStatus`)"
				+" VALUES(:userId, :name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";

	}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer uId) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findById(Integer uId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByProp(String fielName, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

}
