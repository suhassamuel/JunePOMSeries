package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.ConstantsDemo;

public class LoginPageTest1 extends BaseTest1 {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = logpg.getTitle();

		Assert.assertEquals(title, ConstantsDemo.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void fogotPwdLinkExist() {

		Assert.assertTrue(logpg.forgotPwdLinkDispalyed());
	}

	@Test(priority = 3)
	public void doLoginTest() {
		logpg.doLogin(prop.getProperty("username"), prop.getProperty("pwd"));

	}

}
