package com.qa.opencart.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ConstantsDemo;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage1 {

	private WebDriver driver;
	private ElementUtil elementUtil;
	// locators
	private By emailid = By.id("input-email");
	private By pwd = By.id("input-password");
	private By loginBtn = By.xpath("//input[@type='submit']");
	private By forgoPwd = By.linkText("Forgotten Password");

	// constructor

	public LoginPage1(WebDriver driver)
	{
		this.driver= driver;
		
		elementUtil = new ElementUtil(this.driver);
	}

	// methods
	
	public String getTitle()
	{
		return elementUtil.waitForTitleIs(ConstantsDemo.LOGIN_PAGE_TITLE, 10);
	}
	
	public boolean forgotPwdLinkDispalyed()
	{
		return elementUtil.doIsDisplayed(forgoPwd);
	}
	
	public AccountsPage1 doLogin(String username, String password)
	{
		elementUtil.doSendKeys(emailid, username);
		elementUtil.doSendKeys(pwd, password);
		elementUtil.doClick(loginBtn);
	
		return new AccountsPage1(driver);
	}
	
	
	

}
