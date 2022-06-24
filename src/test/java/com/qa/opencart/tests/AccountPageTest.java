package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.ConstantsDemo;

public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		accountpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("pwd"));
	}

	@Test
	public void accountPageTitleTest() {
		String title = accountpage.getAccountPageTitle();

		System.out.println("Account page title is :" + title);

		Assert.assertEquals(title, ConstantsDemo.Account_TITLE);
	}

	@Test
	public void accPageSuggestionList() {
		List<String> accountSuggestionList = accountpage.getAccounSuggestionList();

		Assert.assertEquals(accountSuggestionList, ConstantsDemo.getExpectedSuggestionList());
	}

	@Test
	public void seachFieldExist() {
		Assert.assertTrue(accountpage.searchFieldExist());
	}

	@DataProvider
	public Object[][] productData() {
		return new Object[][] { { "Macbook" }, { "iMac" }, { "Apple" }
		};
	}

	@Test(dataProvider="productData")
	public void searchTest(String productName) {

		searchResultPage = accountpage.doSearchProduct(productName);

		

		Assert.assertTrue(searchResultPage.getProductResultCount() > 0);

		System.out.println("Result count : " + searchResultPage.getProductResultCount());
	}
	
	@DataProvider
	public Object[][] productSelectData()
	{
		return new Object[][]
				{
					{"MacBook","MacBook Pro"},
					{"iMac","iMac"},
					{"Apple","Apple Cinema 30\""}
				};
	}
	
	@Test(dataProvider="productSelectData")
	public void selectProductTest(String productName, String mainProductName)
	{
		searchResultPage = accountpage.doSearchProduct(productName);
		
		productInfoPage = searchResultPage.selectProduct(mainProductName);
		
		
		Assert.assertEquals(productInfoPage.getProduceHeaderTest(), mainProductName);
		
		
	}

}
