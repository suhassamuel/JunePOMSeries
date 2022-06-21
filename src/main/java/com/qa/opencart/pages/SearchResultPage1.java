package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultPage1 {

	private WebDriver driver;
	private ElementUtil elementUtil;
	// by locator

	private By pageHeader = By.cssSelector("div#content h1");
	//private By searchProductList = By.xpath("//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//div[@class='image']//a");
	
	
	
	
	private By productResults = By.xpath("//div[@class='caption']//a");
	

	public SearchResultPage1(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String pageHeader() {
		return elementUtil.doGetText(pageHeader);
	}

	public int searchProductListCount() {
		// elementUtil.getElementsTextListWithWait(searchProductList, 10);

		return elementUtil.waitForElementsToBeVisible(productResults, 10).size();

	}

	public ProductInfoPage1 selectProduct(String mainProductName) {

		List<WebElement> eles = elementUtil.waitForElementsToBeVisible(productResults, 10);

		for (WebElement e : eles) {
			String text = e.getText();

			if (text.equals(mainProductName)) {
				System.out.println(text);
				e.click();
				break;
			}
		}

		return new ProductInfoPage1(this.driver);
	}

}
