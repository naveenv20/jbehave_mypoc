package com.learnjbehave;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;




public class TestUtil {
	
	public  static Hashtable<String,String> objdata;
	public  static WebDriver d1;
	public static Logger APPLICATION_LOG;
	public   static int counter=0;


	
	public static void init(String testcase) {
		System.out.println("inside landing page");
		APPLICATION_LOG=Logger.getLogger("devpinoyLogger");
		APPLICATION_LOG.debug(testcase);
		APPLICATION_LOG.debug("**********init function--Start*************");
		objdata=Util.getobjectdata(testcase, "Suite");
		APPLICATION_LOG.debug("**********init function--End*************");
		counter++;
		APPLICATION_LOG.debug("*&*&*&**&*&*&*&"+counter);
	}

	
public void openbrowser(String browser){
		
		//Calling the initialisation function ********************
	
		if(browser.equalsIgnoreCase("Firefox")){
			d1=new FirefoxDriver();
			d1.manage().window().maximize();;
			d1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	
	public void navigate(String URL){
		d1.get(URL);
		APPLICATION_LOG.debug("url is opened");
		
		//ifpromopopupexists("promo_pop_cancel");
	}
	
public void click(String identifier){
		
		d1.findElement(By.xpath(objdata.get(identifier))).click();
		
	}
	
public void type(String identifier, String datatotype){
	d1.findElement(By.xpath(objdata.get(identifier))).clear();
	d1.findElement(By.xpath(objdata.get(identifier))).sendKeys(datatotype);
}

public void select(String identifier, String valuetoselect,WebDriver d1){
WebElement 	e=d1.findElement(By.xpath(objdata.get(identifier)));
Select element= new Select(e);
element.selectByVisibleText(valuetoselect);
}

public void selectradio(String identifier, String valuetoselect,WebDriver d1){
	//not implemented fully , check this *****
	d1.findElement(By.xpath(objdata.get(identifier))).click();
}
	
public boolean elementpresence(String object)	{
	int count;
	count=d1.findElements(By.xpath(objdata.get(object))).size();
	if(count>0)
		return true;
		else
			return false;
	
}

public List<WebElement> findelements(String object){
	List<WebElement> elements;
	elements=d1.findElements(By.xpath(objdata.get(object)));
			if(elements.size()>0)
			return elements;
			else
			{
				System.out.println("No elements");
			
				return null;
			}
}


public String gettextofaelement(String identifier){
	String textvalue=d1.findElement(By.xpath(objdata.get(identifier))).getText();
	return textvalue;
}

public void checkpagetitle() throws InterruptedException{
	//String actual_title=d1.getTitle();
	List<WebElement> tabs_available=d1.findElements(By.xpath(objdata.get("page_menu")));
	System.out.println(tabs_available.size());
	for(int i=0;i<13;i++){
		tabs_available=d1.findElements(By.xpath(objdata.get("page_menu")));
		WebElement e=tabs_available.get(i);
		e.click();
		Thread.sleep(6000);
		System.out.println(d1.getTitle());
	}
	
}

public void keyboardaction(String keyboardkey){
	Actions act=new Actions(d1);
	if(keyboardkey.equalsIgnoreCase("ENTER"))
	act.keyDown(Keys.ENTER);
	
}



/********************APPLICATION SPECIFIC FUNCTIONS************************************/

public void ifpromopopupexists(String identifier){
	
List<WebElement> pops=d1.findElements(By.xpath(objdata.get(identifier)));
if(pops.size()>0){
	APPLICATION_LOG.debug("pop up exists");
	WebElement ele=d1.findElement(By.xpath(objdata.get(identifier)));
	Actions act= new Actions(d1);
	act.moveToElement(ele).build().perform();
	act.click().build().perform();
}
else
APPLICATION_LOG.debug("No popup");


}


public void excepcleanup(Exception e,String name){
	APPLICATION_LOG.debug("****Exception occured so trying to clean up******");
	if(d1!=null){
		APPLICATION_LOG.debug("****Closing the browser from exceptiom part******");
		takescreenshot();
		e.printStackTrace();
		APPLICATION_LOG.error("Exception !!!",e);
		APPLICATION_LOG.error("&^&^&^&^&^&^&^&^&^&^&^"+name);
		d1.quit();
	}
}

public void takescreenshot(){
	
	String scrsht_filename=String.valueOf(System.currentTimeMillis())+".jpg";
	File scrFile = ((TakesScreenshot)d1).getScreenshotAs(OutputType.FILE);
try {
FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"//target//screenshots//"+scrsht_filename));
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}
