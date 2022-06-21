package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage1 {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By mainProductImageCount = By.xpath("//div[@id='content']//ul/li[@class='image-additional']/a");
	private By mainProductheader = By.cssSelector("div#content h1");
	private By mainProductdetailsInfo = By.cssSelector("div#content div.row div.col-sm-4 ul:nth-of-type(1) li");
	private By mainProductPriceInfo = By.cssSelector("div#content div.row div.col-sm-4 ul:nth-of-type(2) li");
	private By mainProductQty = By.id("input-quantity");

	private Map<String, String> productInfo;

	public ProductInfoPage1(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String mainProductHeader() {
		return elementUtil.doGetText(mainProductheader);
	}
	
	public int mainProductImgCount()
	{
		return elementUtil.doGetElements(mainProductImageCount).size();
	}

	public Map<String, String> getProductInfo() {
		productInfo = new HashMap<String, String>();
		productdetails();
		pricedetails();
		
		return productInfo;

	}
	
	private void productdetails() {
		List<WebElement> eles = elementUtil.doGetElements(mainProductdetailsInfo);

		for (WebElement e : eles) {
			String st = e.getText();
			String meta[] = st.split(":");

			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();

			productInfo.put(metaKey, metaValue);
		}
	}

	private void pricedetails() {
		List<WebElement> elep = elementUtil.doGetElements(mainProductPriceInfo);

		String mainPrice = elep.get(0).getText();
		String exPrice = elep.get(1).getText();
		productInfo.put("price", mainPrice);
		productInfo.put("ExTax", exPrice);
	}

}
