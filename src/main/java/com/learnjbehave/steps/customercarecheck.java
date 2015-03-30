package com.learnjbehave.steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;

import com.learnjbehave.TestUtil;
import com.learnjbehave.pages.Customercarepage;
import com.learnjbehave.pages.Landingpage;

public class customercarecheck extends TestUtil {

	

	Landingpage landingpage= new Landingpage(d1,"Customercaretest");
	Customercarepage customercarepage;
	
	@Then("user clicks on the customercare link")
	public void userclickcustomercarelink(){
		customercarepage=landingpage.navigatetocustomercare();
	}
	
	
	@Then("user select the case as <case_type>")
	public void userselectscasetype(@Named("case_type")String case_type){
		customercarepage.selecttheissuetype("issuetype_links", case_type);
	}
	
	@Then("user selects the <question_number>")
	public void userselectsquestionum(@Named("question_number")String question_number) throws Exception{
		try{
		customercarepage.selectthequestionnumber(question_number);
		customercarepage.getquestion_text("question_text");
		System.out.println();
		}catch(Exception e){
			class Local {};
		    String name = Local.class.getEnclosingMethod().getName();
			excepcleanup(e,name);
			throw e;
			
		}
	}
	
}

	



