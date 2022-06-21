package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest {

	@BeforeClass
	public void registerationPageSetup() {
		registrationPage = loginpage.navigateToRegister();
	}

	public String randomEmail() {
		Random randomEmail = new Random();

		String emailadd = "testautomationjune" + randomEmail.nextInt(1000) + "@gmail.com";
		return emailadd;
	}

	@DataProvider
	public Object[][] getRegisterData() {
		
		return ExcelUtil.getTestData("Register");
	}

	@Test(dataProvider = "getRegisterData")
	public void userRegistrationTest(String firtName, String lastName, String telephone, String password,
			String subscribe) {

		// Assert.assertTrue(registrationPage.doRegister("testFirstName",
		// "testLastName", randomEmail(), "1234568911", "test1234", "yes"));

		Assert.assertTrue(
				registrationPage.doRegister(firtName, lastName, randomEmail(), telephone, password, subscribe));
	}

}
