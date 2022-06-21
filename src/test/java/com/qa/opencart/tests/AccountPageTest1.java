package com.qa.opencart.tests;



import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.utils.ConstantsDemo;

public class AccountPageTest1 extends BaseTest1 {

	@BeforeClass
	public void accPageSetup() {
		accountpage1 = logpg.doLogin(prop.getProperty("username"), prop.getProperty("pwd"));
	}
	
	
	@Test
	public void accountPageTitleTest()
	{
		String title = accountpage1.doGetTitle();
		
		Assert.assertEquals(title, ConstantsDemo.Account_TITLE);
	}
	
	
	@Test
	public void getHeaderList()
	{
		List<String> accountSuggestionList = accountpage1.getSuggestionList();
		
		Assert.assertEquals(accountSuggestionList, ConstantsDemo.getExpectedSuggestionList());
			
	}
	
	@Test
	public void searchProductTest()
	{
		accountpage1.searchProduct("MacBook");
	}

}
