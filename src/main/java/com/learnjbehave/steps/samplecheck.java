package com.learnjbehave.steps;

import org.jbehave.core.annotations.Given;

import com.learnjbehave.TestUtil;

public class samplecheck extends TestUtil{



	
	@Given("ABC IS GOOD")
	public void abcisgood(){
		init("abc");
	System.out.println("BINDAS");
	}
	
	
}
