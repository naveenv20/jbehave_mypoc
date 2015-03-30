package com.learnjbehave.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.learnjbehave.TestUtil;

public class Searchresultspage extends TestUtil {
	
	
	List<WebElement> searchresultsonthepage;
	Itemviewpage itmvwpage;
	
	public Searchresultspage(WebDriver d1){
		APPLICATION_LOG.debug("**********Searchresults page***************");
	}
	
	
	public void getsearchresults(){
		searchresultsonthepage=findelements("search_results");
		APPLICATION_LOG.debug("number of search results in the page:::"+searchresultsonthepage.size());
	}

	public Itemviewpage selectaresult(){
		searchresultsonthepage.get(3).click();
		return new Itemviewpage(d1);
	}
	
	
}
