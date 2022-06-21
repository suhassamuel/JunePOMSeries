package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ConstantsDemo;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage1 {
	
	private WebDriver driver ;
	private ElementUtil elementUtil;
// 1 .locator
	
	private By logo = By.xpath("//div[@id='logo']");
	private By suggestionList = By.xpath("//div[@id='content']/h2"); 
	private By logOutLink = By.linkText("Logout");
	private By searchField = By.name("search");
	private By searchBtn = By.xpath("//div[@id='search']//button[@type='button']");
	
	
// 2. constructor
	
	public AccountsPage1(WebDriver driver)
	{
		this.driver= driver;
		elementUtil = new ElementUtil(this.driver);
	}
// 3. mehod	
	
	public String doGetTitle()
	{
		return elementUtil.waitForTitleIs(ConstantsDemo.Account_TITLE, 10);
	}
	
	public void getAccountPageHeader()
	{
		elementUtil.doGetText(logo);
	}
	
	public boolean logoutLinkExist()
	{
		return elementUtil.doIsDisplayed(logOutLink);
	}
	
	
	public List<String>  getSuggestionList()
	{
		List<WebElement> lstEles = elementUtil.waitForElementsToBeVisible(suggestionList, 10);
		
		List<String> txtList = new ArrayList<String>();
		
		
		for(WebElement ele : lstEles)
		{
			txtList.add(ele.getText());
		}
		
		return txtList;
	}
	
	public boolean searchFieldExist()
	{
		return elementUtil.doIsDisplayed(searchField);
	}
	
	public SearchResultPage1 searchProduct(String productName)
	{
		elementUtil.doSendKeys(searchField, productName);
		elementUtil.doClick(searchBtn);
		
		return new SearchResultPage1(this.driver);
		
	}
	
	
}
