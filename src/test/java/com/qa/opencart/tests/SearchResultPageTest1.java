package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchResultPageTest1 extends BaseTest1 {

	@BeforeClass

	public void accPageSetup() {
		accountpage1 = logpg.doLogin(prop.getProperty("username"), prop.getProperty("pwd"));
	}

	@Test
	public void productHeaderTest() {
		searchResultPage1 = accountpage1.searchProduct("MacBook");

		Assert.assertEquals(searchResultPage1.pageHeader(), "Search - MacBooks");

	}

	@Test
	public void mainProductSearch() {
		searchResultPage1.selectProduct("MacBook");
	}

}
