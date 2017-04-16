package com.will.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.will.utils.ConfigUtils;


public class DButils {

	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection() throws Exception{
		Connection connection = null;
		Properties properties = ConfigUtils.getProperties("jdbc.properties");
		String url = properties.getProperty("jdbc.url");
		String user = properties.getProperty("jdbc.user");
		String password = properties.getProperty("jdbc.password");
		String driverClass = properties.getProperty("jdbc.driverClass");
		
		Class.forName(driverClass);
		connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
	
    /**release resource
     * @param rs
     * @param st
     * @param con
     */
    public static void release(ResultSet rs,Statement st,Connection con){
    	
    	if(rs!=null){
    		try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}if(st!=null){
    		
    		try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}if(con!=null){
    		try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }	
}
