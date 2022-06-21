package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.ExcelUtil;

public class ProductInfoPageTest1 extends BaseTest1 {

	@BeforeClass
	public void accPageSetup() {
		accountpage1 = logpg.doLogin(prop.getProperty("username"), prop.getProperty("pwd"));
	}

	@DataProvider
	public Object[][] productsData()
	{
		return ExcelUtil.getTestData("Product");
	}
	
	@Test(dataProvider="productsData")
	public void getMainProductHeaderTest(String product, String MainProduct) {
		searchResultPage1 = accountpage1.searchProduct(product);
		productInfoPage1 = searchResultPage1.selectProduct(MainProduct);
		System.out.println(productInfoPage1.mainProductHeader());
		
	}
	
//	public void getMainProductHeaderTest() {
//		searchResultPage1 = accountpage1.searchProduct("MacBook");
//		productInfoPage1 = searchResultPage1.selectProduct("MacBook Pro");
//		System.out.println(productInfoPage1.mainProductHeader());
//	}

	@Test
	public void getImageCountTest() {
		searchResultPage1 = accountpage1.searchProduct("MacBook");
		productInfoPage1 = searchResultPage1.selectProduct("MacBook Pro");
		System.out.println(productInfoPage1.mainProductImgCount());

	}

	@DataProvider
	public Object[][] productData() {
		return new Object[][] { { "MacBook", "MacBook Pro" } };
	}

	@Test(dataProvider="productData")
	
	public void getProductInfoTest(String productName,String productMain) {
		//searchResultPage1 = accountpage1.searchProduct("MacBook");
		//productInfoPage1 = searchResultPage1.selectProduct("MacBook Pro");

		searchResultPage1 = accountpage1.searchProduct(productName);
		productInfoPage1 = searchResultPage1.selectProduct(productMain);
		
		productInfoPage1.getProductInfo().forEach((k, v) -> System.out.println(k + ":" + v));

		Assert.assertEquals(productInfoPage1.getProductInfo().get("Brand"), "Apple");

		Assert.assertEquals(productInfoPage1.getProductInfo().get("price"), "$2,000.00");

	}

}
