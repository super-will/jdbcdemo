package com.will.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.will.dao.StudentDao;
import com.will.entity.Student;
import com.will.jdbc.DButils;

/**
 * 
 * JDBC实现
 * @author hcguo
 *
 */
public class StudentDaoImpl implements StudentDao{
     /**
     * @return
     * @throws SQLException
     */
    public List<Student> query() throws Exception{
    	List<Student> studentList =  new ArrayList<Student>();
    	 Connection connection = DButils.getConnection();
    	 PreparedStatement ps = connection.prepareStatement("SELECT * FROM STUDENT");
         ResultSet rs = ps.executeQuery();
         while(rs.next()){
        	 Student student = new Student();
        	 student.setId(rs.getInt("ID"));
        	 student.setName(rs.getString("NAME"));
        	 student.setAge(rs.getInt("AGE"));
        	 student.setSex(rs.getString("SEX"));
        	 studentList.add(student);
        	 System.out.println(rs.getString("NAME"));
         }
         
    	 return studentList;
    	 
     }
}
