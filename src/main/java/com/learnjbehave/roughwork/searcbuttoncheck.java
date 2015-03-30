package com.learnjbehave.roughwork;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class searcbuttoncheck {

	

	public void searcbtnchk() throws InterruptedException{
		WebDriver d1=new FirefoxDriver();
		d1.get("http://flipkart.com");
		d1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d1.findElement(By.xpath("//*[@id='fk-mainhead-id']/div[1]/div/div[2]/div[1]/ul/li[8]/a")).click();
		Thread.sleep(3000);
		d1.findElement(By.xpath("//*[@id='login_email_id']")).sendKeys("naveenkv20@gmail.com");
		d1.findElement(By.xpath("//*[@id='login_password']")).sendKeys("test123");
	d1.findElement(By.xpath("//*[@value='Login' and @class='btn btn-blue']")).click();
	Thread.sleep(8000);
		d1.findElement(By.xpath("//*[@id='fk-top-search-box']")).sendKeys("Timex Watch");
		d1.findElement(By.xpath("//*[@id='fk-header-search-form']/div/div/div[2]/input[1]")).click();
		
	}
	
	
}
