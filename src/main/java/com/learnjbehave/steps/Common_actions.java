package com.learnjbehave.steps;



import java.lang.reflect.Method;












import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.BeforeScenario;
import org.junit.Assert;
import com.learnjbehave.TestUtil;

public class Common_actions extends TestUtil  {


	public Common_actions() {
		
	}
	
	@BeforeStories
	public void bfstories(){
		APPLICATION_LOG.debug("*********BEFORE ALL STORIES***************");
	}
	
	@AfterStories
	public void afstories(){
		
		APPLICATION_LOG.debug("*********AFTER ALL STORIES***************");
	}
	
	@BeforeScenario
	public void  BeforeScenario(){
	APPLICATION_LOG.debug("****TEST SCENARIO BEGUINED*******");	
	
	}

	@AfterScenario
	public void afterscenario(){
		d1.quit();
		APPLICATION_LOG.debug("****TEST SCENARIO ENDED*******");	
		
	}

	@BeforeStory
	public void  BeforeStory(){
	APPLICATION_LOG.debug("****TEST STORY BEGUINED*******");	
		

	}
	
	@Given("The browser <browsertype> is opened")
	public void browseropen(@Named("browsertype") String browsertype){
		
		openbrowser(browsertype);
	}
	
	@Then("User opens the <URL>")
	public void navigatetourl(@Named("URL")String url){
		navigate(url);
	}
	
	@Then("I will enter the login name as <login_name> and password as <password>")
	public void Iwillenteruname(@Named("login_name")String login_name,@Named("password") String password){
		APPLICATION_LOG.debug("&&&&&&"+login_name+"&&&&"+password);
	
		type("Username_identifier", login_name);
		type("Password_identifier", password);
	}
	
	@Then("I will hit enter")
	public void Iwillhitenter(){
	click("Login_Button");	
	}
	
	@Then("I will check whether the login is successfull or not")
	public void Iwilluserlogged(){
	boolean islogged=elementpresence("Loggin_successful_identifier")	;
	boolean expctd=true;
	Assert.assertEquals(expctd, islogged);
	}
	
	@Then("user ends the test case and closed the browser")
	public void teardown(){
		
		
		d1.quit();
		APPLICATION_LOG.debug("***************CLOSING THE BROWSER*******************");
	}
	
	
	
}
