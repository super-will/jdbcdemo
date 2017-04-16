package com.will.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {


	/**
	 * @param propertieFileName
	 * @return
	 */
	public static Properties getProperties(String propertieFileName){
		InputStream is = null;
		Properties properties = new Properties();
		try {
			is = ConfigUtils.class.getClassLoader().getResourceAsStream(propertieFileName);
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
		
	}
}
