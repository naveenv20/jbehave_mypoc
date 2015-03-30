package com.learnjbehave.roughwork;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.security.Credentials;

public class landingpromotocheck {

	@Test
	public void promocheck() throws InterruptedException, AWTException{
		WebDriver d1=new FirefoxDriver();
		d1.get("http://flipkart.com");
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	WebElement ele=d1.findElement(By.xpath("html/body/div[5]/div/div/a"));
Actions act= new Actions(d1);
act.moveToElement(ele).build().perform();
act.click().build().perform();


/*
List<WebElement> abc= d1.findElements(By.tagName("iframe"));
System.out.println(abc.size());
*/
/*
Set<String> windowId = d1.getWindowHandles();    // get  window id of current window
Iterator<String> itererator = windowId.iterator();   

String mainWinID = itererator.next();
String  newAdwinID = itererator.next();
d1.switchTo().window(newAdwinID);
System.out.println(d1.getTitle());
Thread.sleep(3000);
d1.close();

d1.switchTo().window(mainWinID);
System.out.println(d1.getTitle());
Thread.sleep(2000);
*/	




	}
	
	
}
