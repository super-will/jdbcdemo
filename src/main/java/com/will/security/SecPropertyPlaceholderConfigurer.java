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

	/* 
	 * 加解密
	 */
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		// TODO Auto-generated method stub
		super.processProperties(beanFactoryToProcess, props);
	}
    
}
