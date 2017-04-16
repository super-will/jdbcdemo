package com.will.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.will.dao.StudentDao;
import com.will.entity.Student;

/**
 * Spring JDBC Template实现
 * @author hcguo
 *
 */
public class StudentDaoSpringImpl implements StudentDao{
	
	private JdbcTemplate jdbcTemplate;



	public List<Student> query() throws Exception {
		List<Student> studentList = jdbcTemplate.query("SELECT * FROM STUDENT",BeanPropertyRowMapper.newInstance(Student.class));
		System.out.println(studentList.size());
		return studentList;
	}

	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
