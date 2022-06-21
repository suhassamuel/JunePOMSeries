package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class ConstantsDemo {

	public final static String LOGIN_PAGE_TITLE ="Account Login";
	public final static String Account_TITLE ="My Account";
	
	public final static List<String> getExpectedSuggestionList()
	{
		return Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
	}
	
	public final static int IMAC_IMAGE_COUNT = 3;
	public final static int MacBook_IMAGE_COUNT = 3;
	
}
