package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory1;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.AccountsPage1;
import com.qa.opencart.pages.LoginPage1;
import com.qa.opencart.pages.ProductInfoPage1;
import com.qa.opencart.pages.SearchResultPage1;

public class BaseTest1 {

	public DriverFactory1 driverFactory;
	public Properties prop;
	public WebDriver driver;
	public LoginPage1 logpg;
	public AccountsPage1 accountpage1 ;
	public SearchResultPage1 searchResultPage1;
	public ProductInfoPage1 productInfoPage1;
	
	@BeforeTest
	public void setup() {

		driverFactory = new DriverFactory1();
		prop = driverFactory.init_prop();
		driver = driverFactory.init_driver(prop);
		logpg = new LoginPage1(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
