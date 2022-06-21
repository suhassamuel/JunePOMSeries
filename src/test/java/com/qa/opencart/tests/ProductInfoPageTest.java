package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.utils.ConstantsDemo;

public class ProductInfoPageTest extends BaseTest {
	@BeforeClass
	public void accPageSetup() {
		accountpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("pwd"));
	}

	@Test
	public void productInfoHeaderTest()
	{
		 searchResultPage = accountpage.doSearchProduct("MacBook");
		
		 productInfoPage =  searchResultPage.selectProduct("MacBook Pro");
		 
		 Assert.assertEquals(productInfoPage.getProduceHeaderTest(), "MacBook Pro");
	}
	
	@Test
	public void productImageTest()
	{
		searchResultPage = accountpage.doSearchProduct("MacBook");
		
		productInfoPage = searchResultPage.selectProduct("MacBook Pro");
			
		Assert.assertEquals(productInfoPage.getProductImageCount(), ConstantsDemo.MacBook_IMAGE_COUNT);
		
	}
	
	
	@Test
	public void productInfoTest()
	{

		searchResultPage = accountpage.doSearchProduct("MacBook");
		
		productInfoPage = searchResultPage.selectProduct("MacBook Pro");
		
		Map<String, String> actProductInfo =  productInfoPage.getProductInfo();
		
		
		actProductInfo.forEach((k,v)-> System.out.println(k + ":" + v) );
		
		
		softAssert.assertEquals(actProductInfo.get("name"),"MacBook Pro");
		softAssert.assertEquals(actProductInfo.get("Brand"),"Apple");
		softAssert.assertEquals(actProductInfo.get("Product Code"),"Product 18");
		softAssert.assertAll();
	}
	
	
}
