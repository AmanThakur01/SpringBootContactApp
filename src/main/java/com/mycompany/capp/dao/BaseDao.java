package com.mycompany.capp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class BaseDao {
	@Autowired
	NamedParameterJdbcTemplate npjt;
	@Autowired
	JdbcTemplate jt;
}
