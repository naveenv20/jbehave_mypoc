package com.learnjbehave.pages;

import org.openqa.selenium.WebDriver;

import com.learnjbehave.TestUtil;

public class Itemviewpage extends TestUtil {
	
	
	
	public Itemviewpage(WebDriver d1){
		APPLICATION_LOG.debug("**********Inside the Itemviewpage*************");
	}
	
	
	public void getwatchname(){
		APPLICATION_LOG.debug("The Result is:::::"+gettextofaelement("Watch_View_Text"));
	}

}
