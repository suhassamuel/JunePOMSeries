package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ConstantsDemo;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1. locator

	private By emailid = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwd = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");

	// 2. constructor

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);

	}

	// 3. methods

	@Step("getting the the login page title")
	public String getTitle() {
		// return driver.getTitle();
		return elementUtil.waitForTitleIs(ConstantsDemo.LOGIN_PAGE_TITLE, 10);
	}

	public boolean forgotPasswordLinkDisplayed() {
		//return driver.findElement(forgotPwd).isDisplayed();
		
		return elementUtil.doIsDisplayed(forgotPwd);
	}

	@Step("verifying login with username{0} and password{1}")
	public AccountsPage doLogin(String username, String pwd) {
//		driver.findElement(emailid).sendKeys(username);
//		driver.findElement(password).sendKeys(pwd);
//
//		driver.findElement(loginBtn).click();
		
		elementUtil.doSendKeys(emailid, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		return new AccountsPage(driver);
	}
	
	public RegistrationPage navigateToRegister()
	{
		 elementUtil.doClick(registerLink);
		 
		 return new RegistrationPage(driver);
	}

}
