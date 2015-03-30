package com.learnjbehave.pages;

import java.util.List;

import net.sourceforge.htmlunit.corejs.javascript.ast.ThrowStatement;

import org.apache.commons.collections.functors.IfClosure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.learnjbehave.TestUtil;

public class Customercarepage extends TestUtil {
	int i=0;
	
	public Customercarepage(WebDriver d1){
		APPLICATION_LOG.debug("********INSIDE THE Customer care Page*****");
		
	}
	
	public void selecttheissuetype(String issuetype_identifier,String issue_type){
		//ifpromopopupexists("promo_pop_cancel");
		List<WebElement> issuelist=findelements(issuetype_identifier);
		
		for(;i<issuelist.size();i++){
			if(issuelist.get(i).getText().equalsIgnoreCase(issue_type)){
				Actions act= new Actions(d1);
				act.moveToElement(issuelist.get(i)).build().perform();
				break;
			}
			
		}
		
	}
	
	
	public void selectthequestionnumber(String question_number) throws Exception{
		
		ifpromopopupexists("promo_pop_cancel");
		String questionlist_identifier=objdata.get("questionnumber_link_part1")+(i+1)+objdata.get("questionnumber_link_part2");
		APPLICATION_LOG.debug("Questionlist::::"+questionlist_identifier);
		List<WebElement> question_list=d1.findElements(By.xpath(questionlist_identifier));	
		Actions act= new Actions(d1);
	
		WebElement element=question_list.get(Integer.parseInt(question_number)-1);
		act.moveToElement(element).build().perform();
		act.click().build().perform();
		try {
			Thread.sleep(3000);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			APPLICATION_LOG.debug("Hello");
		APPLICATION_LOG.debug(e.toString());
			throw new Exception();
		}
	}


public void getquestion_text(String identifier){
	APPLICATION_LOG.debug("QUESTION TEXT::::::::"+gettextofaelement(identifier));
}

}
