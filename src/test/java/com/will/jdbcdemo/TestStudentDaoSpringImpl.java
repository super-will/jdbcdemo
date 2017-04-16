package com.will.jdbcdemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.will.dao.impl.StudentDaoSpringImpl;

public class TestStudentDaoSpringImpl {

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
	public void testQuery() throws Exception {
		StudentDaoSpringImpl daoSpring = (StudentDaoSpringImpl) context.getBean("StudentDaoSpringImpl");
		daoSpring.query();
	}

}
