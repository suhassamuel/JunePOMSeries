package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By productHeader = By.cssSelector("#content h1");
	private By produceImages = By.cssSelector(".image-additional img");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By priceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By qty = By.id("input-quantity");
	private By addToCardBtn = By.id("button-cart");
	private Map<String, String> productInfoMap;
	
	
	
	public ProductInfoPage(WebDriver driver)
	{
		this.driver = driver;
		
		elementUtil = new ElementUtil(this.driver);
	}
	public String getProduceHeaderTest() {
		return elementUtil.doGetText(productHeader);
	}

	public int getProductImageCount() {
		return elementUtil.waitForElementsToBeVisible(produceImages, 10).size();
	}

	public Map<String, String> getProductInfo() {
	 //	productInfoMap = new HashMap<String, String>();
		productInfoMap = new LinkedHashMap<String, String>();
		
		productInfoMap.put("name", getProduceHeaderTest());
		getProductMetaData();
		getProductPriceData();

		return productInfoMap;

	}

	private void getProductMetaData() {
		List<WebElement> metaList = elementUtil.doGetElements(productMetaData);

		for (WebElement e : metaList) {
			String text = e.getText();

			String meta[] = text.split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfoMap.put(metaKey, metaValue);
		}
	}

	private void getProductPriceData() {
		// price:
		List<WebElement> metaPriceList = elementUtil.doGetElements(productMetaData);

		String price = metaPriceList.get(0).getText().trim();
		String exPrice = metaPriceList.get(1).getText().trim();
		productInfoMap.put("price", price);
		productInfoMap.put("exTaxPrice", exPrice);

	}

}
