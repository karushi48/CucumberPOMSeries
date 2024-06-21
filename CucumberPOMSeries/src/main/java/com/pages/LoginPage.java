package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//By locator or object repository
	private By username=By.id("user-name");
	private By password=By.id("password");
	private By loginButton=By.id("login-button");
	
	//Constructor
	public LoginPage(WebDriver driver){
		 this.driver=driver;
	}
	
	//page action: features(behavior) of the page the form of methods:
	public String getLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public void enterUsername(String userNameEntered) {
		 driver.findElement(username).sendKeys(userNameEntered);
	}
	
		 public void enterPassword(String passwordEntered) {
			 driver.findElement(password).sendKeys(passwordEntered);

	}
		 public void clickonLogin() {
			 driver.findElement(loginButton).click();
		 }
	
}
