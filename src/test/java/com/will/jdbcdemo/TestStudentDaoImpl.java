package com.will.jdbcdemo;


import org.junit.Test;

import com.will.dao.impl.StudentDaoImpl;


public class TestStudentDaoImpl {
	


	@Test
	public void testStudentDao() throws Exception {
		StudentDaoImpl studentDaoImp = new StudentDaoImpl();
		studentDaoImp.query();
	}
	

}
