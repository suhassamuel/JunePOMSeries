package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.SearchResultPage;


public class BaseTest {

	public DriverFactory driverFactory;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginpage;
	public AccountsPage accountpage ;
	public SearchResultPage searchResultPage;
	public ProductInfoPage productInfoPage;
	public RegistrationPage registrationPage;
	
	public SoftAssert softAssert  = new SoftAssert();
	
	
	@Parameters({"browser","browserversion"})
	@BeforeTest
	public void setup(String browserName, String browserVersion)
	{
		driverFactory = new DriverFactory();
		prop = driverFactory.init_prop();
		
		if(browserName!= null)
		{
			prop.setProperty("browser", browserName);
			prop.setProperty("browserversion", browserVersion);
		}
				
		driver = driverFactory.init_driver(prop);
		loginpage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown()
	{
	//	driver.quit();
	}
	
	
		
}
