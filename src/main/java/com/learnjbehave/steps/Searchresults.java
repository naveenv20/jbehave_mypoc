package com.learnjbehave.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.WebDriver;

import com.learnjbehave.TestUtil;
import com.learnjbehave.pages.Itemviewpage;
import com.learnjbehave.pages.Landingpage;
import com.learnjbehave.pages.Searchresultspage;

public class Searchresults extends TestUtil{

	Landingpage landingpage= new Landingpage(d1,"Login");
	Searchresultspage searchresultspage;
	Itemviewpage itemviewpage;
	
	
	public void searchresults() {

	}
	
@Then("the user logs into the system with the <username> and <password>")
	public void userlogin(@Named("username")String username,@Named("password")String password){
	landingpage.dologin(username, password);
}

@Then("user searhces for <searchvalue>")
public void searching(@Named("searchvalue")String searchvalue){
	searchresultspage=landingpage.searchresults(searchvalue);
	searchresultspage.getsearchresults();
}
	
@Then("selects the Third item from the search results")
public void selectthethirditem(){
	itemviewpage=searchresultspage.selectaresult();
}

@Then("View the item")
public void viewtheittem(){
	itemviewpage.getwatchname();
}

}
