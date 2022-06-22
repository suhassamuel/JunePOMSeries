package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class Cart {
	
	private By cart = By.id("cart");
	
	public void getcart()
	{
		
		System.out.println("cart method"+cart);
	}

}
