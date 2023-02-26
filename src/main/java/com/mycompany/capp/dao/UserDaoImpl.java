package com.mycompany.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.mycompany.capp.domain.User;
import com.mycompany.capp.rm.UserRowMapper;
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public void save(User u) {
		String  sql = "INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`, `role`, `loginStatus`)"
				+" VALUES(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("name", u.getName());
		ps.addValue("phone", u.getPhone());
		ps.addValue("email", u.getEmail());
		ps.addValue("address", u.getAddress());
		ps.addValue("loginName", u.getLoginName());
		ps.addValue("password", u.getPassword());
		ps.addValue("role", u.getRole());
		ps.addValue("loginStatus", u.getLoginStatus());
		
//		GeneratedKeyHolder kh = new GeneratedKeyHolder();
//		int id =()(kh.getKey());
		
		npjt.update(sql, ps);
//		u.setUserId(id);
	}

	@Override
	public void update(User u) {
		String sql = "UPDATE user SET name=:name,"
				+ "phone=:phone,"
				+ "email=:email,"
				+ "address=:address,"
				+ "loginName=:loginName,"
				+ "password=:password,"
				+ "role=:role,"
				+ "loginStatus=:loginStatus"
				+ "WHERE userId=:userId";
		Map<String,Object> m = new HashMap<String, Object>();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());       
        m.put("role", u.getRole());
        m.put("loginStatus", u.getLoginStatus());
        m.put("userId", u.getUserId());
        npjt.update(sql, m);

	}

	@Override
	public void delete(Integer uId) {
		String sql = "DELETE FROM user WHERE userId=?";
		jt.update(sql, uId);

	}

	@Override
	public User findById(Integer uId) {
		String sql = "SELECT * FROM user WHERE userId = "+uId;
		return jt.queryForObject(sql,new UserRowMapper());
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM user";
		return jt.query(sql,new UserRowMapper());
		
	}

	@Override
	public List<User> findByProp(String fielName, Object value) {
		String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user WHERE "+fielName+"=?";
         return jt.query(sql, new UserRowMapper(), value);
	}

}
