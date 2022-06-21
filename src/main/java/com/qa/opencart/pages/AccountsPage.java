package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ConstantsDemo;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By header = By.cssSelector("div#logo");
	private By suggestionList = By.xpath("//div[@id='content'] /h2");
	private By logOutLink = By.linkText("Logout");
	// private By searchField = By.xpath("//input[@name='search']");
	private By searchField = By.name("search");
	private By searchBtn = By.xpath("//div[@id='search']//button[@type='button']");
	

	public AccountsPage(WebDriver driver) {
		this.driver = driver;

		elementUtil = new ElementUtil(this.driver);
	}

	public String getAccountPageTitle() {
		return elementUtil.waitForTitleIs(ConstantsDemo.Account_TITLE, 10);
	}

	public String getAccountPageHeader() {
		return elementUtil.doGetText(header);
	}

	public boolean isLogoutLinkExist() {
		return elementUtil.doIsDisplayed(logOutLink);
	}

	public void Logout() {
		if (isLogoutLinkExist()) {
			elementUtil.doClick(logOutLink);
		}
	}

	public List<String> getAccounSuggestionList() {
		List<WebElement> eles = elementUtil.waitForElementsToBeVisible(suggestionList, 10);

		List<String> accSecList = new ArrayList<String>();
		for (int i = 0; i < eles.size(); i++) {

			accSecList.add(eles.get(i).getText());
			
		}
		return accSecList;

	}
	
	public boolean searchFieldExist()
	{
		return elementUtil.doIsDisplayed(searchField);
	}
	
	public SearchResultPage doSearchProduct(String productName)
	{
		System.out.println("Search :"+productName);
		elementUtil.doSendKeys(searchField, productName);
		elementUtil.doClick(searchBtn);
		return new SearchResultPage(driver);
	}

}
