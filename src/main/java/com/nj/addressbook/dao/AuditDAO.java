package com.nj.addressbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nj.addressbook.entities.Contact;


@Repository
public class AuditDAO 
{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AuditDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void createAudit(String msg)
	{
		String sql = "insert into audt(msg) values(?)";
		jdbcTemplate.update(sql, new Object[]{msg});
		System.err.println("inserted audit record");
	}
	

}

