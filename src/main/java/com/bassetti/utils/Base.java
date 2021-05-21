package com.bassetti.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public enum Browser {
		CHROME("chrome"), FIREFOX("firefox"), IE("ie");

		public String value;

		Browser(String value) {
			this.value = value;
		}

		String getValue() {
			return this.value;
		}
	}

	private String browser;
	private WebDriver driver;
	private int maxTimeLimit;
	private String url;

	public WebDriver init() throws Exception {
		
		// Get client data from properties file
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + File.separator + "config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		browser = prop.getProperty("browser");
		maxTimeLimit = Integer.parseInt(prop.getProperty("maxTimeLimit"));
		url = prop.getProperty("url");
		
		// create driver object for different browsers
		if (this.browser.equals(Browser.CHROME.getValue())) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "driver" + File.separator + "chromedriver.exe");
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(maxTimeLimit, TimeUnit.MILLISECONDS);
			driver.get(url);
		}
		
		return driver;
	}

}
