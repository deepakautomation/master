package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfigFileReader {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream("C:\\Users\\dsood1\\Framework19Feb1100\\Meritnation\\Data.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver=new FirefoxDriver();
		
		driver.get(prop.getProperty("URL"));
		
	}

}
