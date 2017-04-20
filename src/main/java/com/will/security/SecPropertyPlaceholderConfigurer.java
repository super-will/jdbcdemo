package com.will.security;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author hcguo
 *
 */
public class SecPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	
	private static final String JDBC_URL = "jdbc.url";
	
	private static final String JDBC_USER = "jdbc.user";
	
	private static final String JDBC_PASSWORD = "jdbc.password";
	
	
	
	/* 
	 * 对配置信息解密
	 */
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		String url = props.getProperty(JDBC_URL);
		String user = props.getProperty(JDBC_USER);
		String password = props.getProperty(JDBC_PASSWORD);
		
		ASEUtils ase = ASEUtils.getInstance();
		try {
			if(url!=null){
				props.setProperty(JDBC_URL, ase.decrypt(url));
			}if(user!=null){
				props.setProperty(JDBC_USER, user);
			}if(password!=null){
				props.setProperty(JDBC_PASSWORD, password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		super.processProperties(beanFactoryToProcess, props);
	}
	
	
    
}
