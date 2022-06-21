package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.ConstantsDemo;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("OPENCART-115")
@Story("OPENCART-116 : Verify login page")
public class LoginPageTest extends BaseTest {

	@Description("verify login page title test")
	@Severity(SeverityLevel.TRIVIAL)
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = loginpage.getTitle();
		Assert.assertEquals(title, ConstantsDemo.LOGIN_PAGE_TITLE);
	}
	
	
	@Test(priority=2)
	public void forgotPwdLinkDisplaytest()
	{
		Assert.assertTrue(loginpage.forgotPasswordLinkDisplayed());
		
	}
	
	@Description("Verify Login functionality")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=3)
	public void dologinTest()
	{
		accountpage= loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("pwd").trim());
		
		
		Assert.assertEquals(accountpage.getAccountPageTitle(),ConstantsDemo.Account_TITLE);
	}
	
}
