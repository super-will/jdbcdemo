package com.will.jdbcdemo;

import java.sql.Connection;

import org.junit.Test;

import com.will.jdbc.DButils;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestDButils extends TestCase {

	@Test
	public void testGetConnection() throws Exception {
       Connection connection = DButils.getConnection();
       Assert.assertNotNull(connection);
	}
	

}
