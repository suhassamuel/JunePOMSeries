package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By searchHeaderName = By.cssSelector("#content h1");
	private By productResults = By.xpath("//div[@class='caption']//a");

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String getPageHeader()
	{
		return elementUtil.doGetText(searchHeaderName);
	}
	public int getProductResultCount() {
		return elementUtil.waitForElementsToBeVisible(productResults, 10).size();
	}

	public ProductInfoPage selectProduct(String mainProductName) {
		List<WebElement> searchList = elementUtil.waitForElementsToBeVisible(productResults, 10);

		for (WebElement e : searchList) {

			String text = e.getText();
			System.out.println(text);

			if (text.equals(mainProductName)) {
				e.click();
				break;
			}
		}

		return new ProductInfoPage(this.driver);

	}
}
