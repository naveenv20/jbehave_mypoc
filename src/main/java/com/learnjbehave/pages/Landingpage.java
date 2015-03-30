package com.learnjbehave.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.learnjbehave.TestUtil;



public class Landingpage extends TestUtil {

	

	public Landingpage(WebDriver d1,String testcase){
		init(testcase);
		System.out.println("**************Landing page object formed***************");
		APPLICATION_LOG.debug("**************Landing page object formed***************");
		
		 	}
	
	
	public void dologin(String username,String password){
	click("login_link");
	type("login_email_Txtbx", username);
	type("password_Txtbx", password);
	click("login_button");
	try {
		Thread.sleep(8000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public Searchresultspage searchresults(String searchwhat){
		type("searchbox", searchwhat);
		click("search_button");
		//keyboardaction("ENTER");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Searchresultspage(d1);
		
	}
	
	
	public Customercarepage navigatetocustomercare(){
		click("Customercare_link");
		return new Customercarepage(d1);
		
	}


	public boolean isloogedinornot(){
		
			
		return false;
		
	}
	
}
