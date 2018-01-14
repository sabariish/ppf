package com.ppsf.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {

	public static String getProperty (String property, String... propertyFileName) throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		
		input = new FileInputStream("config.properties");

		// load a properties file
		prop.load(input);
		return prop.getProperty(property);
	}
}
