package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {
	 public WebDriver driver;
	 public static ThreadLocal<WebDriver> tLDriver = new ThreadLocal<>();
	 public WebDriver init_driver(String browser) {
			
			System.out.println("browser value is" +browser);
			
			if(browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				tLDriver.set(new ChromeDriver());
				
			}else if(browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				tLDriver.set(new FirefoxDriver());
			
			}else if(browser.equals("safari")) {
				
				tLDriver.set(new SafariDriver());
				
			}else {
				System.out.println("Please pass the correct browser value"+ browser );
			}
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			
			return driver;
	 }
			public static synchronized WebDriver getDriver() {
				return tLDriver.get();
				
			}

}
