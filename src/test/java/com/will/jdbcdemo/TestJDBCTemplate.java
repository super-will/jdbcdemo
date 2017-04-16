package com.will.jdbcdemo;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJDBCTemplate {
	private ApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("springbeans.xml");
	}
	
	@After
	public void tearDown() throws Exception {
		context = null;
	}

	@Test
	public void testDataSource() {
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		assertNotNull(dataSource);
	}
	
	@Test
	public void testJdbcTemplate() {
		JdbcTemplate dao = (JdbcTemplate) context.getBean("jdbcTemplate");
		assertNotNull(dao);
	}
}
