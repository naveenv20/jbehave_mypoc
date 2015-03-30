package com.learnjbehave.steps;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.openqa.selenium.support.PageFactory;

import com.learnjbehave.pages.Landingpage;


public class Sampletest {
	
	
	@Given("first number as num1")
public void first_num(){
		System.out.println("num1ooo");
		//landingpage lp=PageFactory.initElements(d1, landingpage.class);
	}
	
	@Given("second number as num2")
public void givensecondnumas(){
	System.out.println("num2");
}

	
	
@Then("prerform the addition")
public void thenperformadd(){
	System.out.println("additi on");
	Assert.assertEquals("true", "true");
}

@Then("preform the Subtraction")
public void thenperformsubt(){
	System.out.println("addition");
	Assert.assertEquals("true", "true");
}
}
