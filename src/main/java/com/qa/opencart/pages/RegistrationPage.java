package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class RegistrationPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");
	private By privacyPolicy = By.xpath("//input[@type='checkbox' and @name='agree']");
	private By continuebtn = By.xpath("//input[@value='Continue']");
	private By successMsg = By.cssSelector("#content h1");
	private By logoutLink = By.linkText("Logout");
	private By RegisterLink = By.linkText("Register");
	
	
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public boolean doRegister(String firstName, String lastName , String email, String telephone , String password , String subScribe  )
	{
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.confirmPassword, password);
		
		if(subScribe.equals("yes"))
		{
			elementUtil.doClick(subscribeYes);
		}
		else			
		{
			elementUtil.doClick(subscribeNo);
		}
		
		elementUtil.doClick(privacyPolicy);
		
		
		elementUtil.doClick(continuebtn);
		
		if(elementUtil.doGetText(successMsg).contains("Your Account Has Been Created!"))
		{
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(RegisterLink);
			return true;
			
		}
		return false;	
		
	}

}
