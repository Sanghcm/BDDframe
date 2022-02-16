package com.qa.utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.IOException;

public class configReader {
	private Properties prop;
	public Properties init_prop() throws IOException {
		
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream ("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}catch (IOException e ) {
			e.printStackTrace();
			
		}
		return prop;
		
	}
	
		
	}


 