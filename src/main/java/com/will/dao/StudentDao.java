package com.will.dao;

import java.util.List;

import com.will.entity.Student;

public interface StudentDao {
	
	public List<Student> query() throws Exception;

}
