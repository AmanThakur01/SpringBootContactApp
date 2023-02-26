package com.mycompany.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mycompany.capp.domain.Contact;
import com.mycompany.capp.rm.ContactRowMapper;

@Repository
public class ContactDaoImpl extends BaseDao implements ContactDao {

	@Override
    public void save(Contact c) {
        String sql = "INSERT INTO contact(userId, name, phone, email, address, remark) "
                + "VALUES(:userId, :name, :phone, :email, :address, :remark)";
        Map<String,Object> m = new HashMap<>();
        m.put("userId", c.getUserId());
        m.put("name", c.getName());
        m.put("phone", c.getPhone());
        m.put("email", c.getEmail());
        m.put("address", c.getAddress());
        m.put("remark", c.getRemark());
        SqlParameterSource ps = new MapSqlParameterSource(m);
        KeyHolder kh = new GeneratedKeyHolder();
        npjt.update(sql, ps, kh);
        c.setContactId(kh.getKey().intValue());
    }

    @Override
    public void update(Contact c) {
        String sql = "UPDATE contact SET name=:name, phone=:phone, email=:email, address=:address, remark=:remark WHERE contactId=:contactId";
        Map<String,Object> m = new HashMap<>();
        m.put("contactId", c.getContactId());
        m.put("name", c.getName());
        m.put("phone", c.getPhone());
        m.put("email", c.getEmail());
        m.put("address", c.getAddress());
        m.put("remark", c.getRemark());
        npjt.update(sql, m);
    }

    

    @Override
    public void delete(Integer contactId) {
        String sql = "DELETE FROM contact WHERE contactId=?";
        jt.update(sql, contactId);
    }

    @Override
    public Contact findById(Integer contactId) {
        String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE contactId="+contactId;
        return jt.queryForObject(sql, new ContactRowMapper() );
    }

    @Override
    public List<Contact> findAll() {
        String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact";
        return jt.query(sql, new ContactRowMapper());
    }

    @Override
    public List<Contact> findByProp(String fielName, Object value) {
        String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE "+fielName+"=?";
        return jt.query(sql, new ContactRowMapper(), value);
    }

}
