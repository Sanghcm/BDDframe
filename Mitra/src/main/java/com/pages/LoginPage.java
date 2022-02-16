package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	private WebDriver driver;
	
	private By signInButton = By.xpath("//button[contains(text(),'Login')]");
	private By emailID	 =	By.xpath("//body/div[1]/div[2]/form[1]/div[1]/input[1]");
	private By Password = By.xpath("//body/div[1]/div[2]/form[1]/div[2]/input[1]");
	private By Rememberme = By.xpath("//body/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/label[1]");
    public LoginPage(WebDriver driver){
    	this.driver =driver;
    	}
    public String getLoginPageTitle() {
    	return driver.getTitle();
    	} 
    public void enterUserName(String username) {
    	driver.findElement(emailID).sendKeys(username);
    	}

    	public void enterPassword(String pwd) {
    	driver.findElement(Password).sendKeys(pwd);
    	} 

    	public void clickOnLogin() {
    	driver.findElement(signInButton).click();
    	}
    	
    
}
	
	
	


